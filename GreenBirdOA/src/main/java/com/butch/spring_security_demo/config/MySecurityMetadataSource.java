package com.butch.spring_security_demo.config;

import java.util.Collection;
import java.util.List;

import com.butch.spring_security_demo.bean.MyResourceBean;
import com.butch.spring_security_demo.mapper.MyResourceBeanMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

/**
 * 用来提供鉴权过程中，访问资源所需的角色
 */
@Component
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    //自动装载
    @Autowired
    MyResourceBeanMapper myResourceBeanMapper;
    //Spring工具类提供的路径匹配器
    AntPathMatcher antPathMatcher=new AntPathMatcher();
    /** 
     * 
     * @param object 被保护的对象:FilterInvocation对象
     * @return Collection<ConfigAttribute> 访问资源所需要的角色集合
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        System.out.println("被保护的对象类型:"+object.getClass());
        //从被保护的对象里获需要访问的资源(网址)
        String requestUrl=((FilterInvocation)object).getRequestUrl();
        //从数据库中得到所有资源,以及目标资源对应的角色集.
        List<MyResourceBean> resourceBeans=myResourceBeanMapper.selectAllResource();
        for (MyResourceBean myResourceBean : resourceBeans) {
            //地址验证
            if(antPathMatcher.match(myResourceBean.getUrl(),requestUrl)
            //并且当前url所对应的角色个数必须大于0
            &&myResourceBean.getRolesArray().length>0){
                //返回资源所需要的角色集合
                return SecurityConfig.createList(myResourceBean.getRolesArray());
            }
        }
        //指定一个匹配不成功的特殊角色
        return SecurityConfig.createList("ROLE_NONE");
    }

    
    /** 
     * @return Collection<ConfigAttribute> 返回的角色名,任何url都会调用
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    
    /** 
     * @param clazz 安全对象的类型,只有支持指定的安全类型才会动用此类的getAttrivutes方法
     * @return boolean 安全对象的类型
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
