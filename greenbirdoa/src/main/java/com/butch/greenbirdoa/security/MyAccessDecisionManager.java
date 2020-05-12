package com.butch.greenbirdoa.security;

import java.util.Collection;

import com.butch.greenbirdoa.security.service.AccessDecisionService;
import com.butch.greenbirdoa.util.ReflectUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

/**
 * AccessDecisionManager框架有3种实现,默认使用投票实现 鉴权决策类,默认实现是使用投票方案
 */
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {
	@Autowired
	AccessDecisionService accessDecisionService;

	/**
	 * 
	 * 自定义鉴权
	 * 
	 * @param authentication:调用该方法的调用者
	 * @param object:被保护的对象,通常是拦截器对象FilterInvocation可以获得req和rep获取前台的信息来进行权限判断
	 * @param configAttributes:与object关联的配置属性,每个ConfigAttribute的getAttribute方法就是角色字符串
	 * @throws AccessDeniedException
	 * @throws InsufficientAuthenticationException
	 */
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		// 过滤器对象可以获取req/rep和requestUrl
		FilterInvocation filterInvocation = (FilterInvocation) object;
		// 判断是否登录,如果是默认的角色未登录就抛出异常由框架重定向到登录界面
		if (authentication.getAuthorities().toString().equals("[ROLE_ANONYMOUS]")) {
			throw new BadCredentialsException("用户未登录");
		}

		/**
		 * 
		 * 会在AccessDecisionService中寻找对应函数鉴权,没找到对应鉴权函数代表此请求不需要权限
		 * 鉴权成功会放行,失败会抛出异常交由MyAccessDeniedHandler执行.
		 * 
		 * 通过反射分发url对应的权限验证,主要验证用户是否能操作目标用户. 
		 * 转换规则:URL:/user/status 请求类型为post 角色为administrative转换成
		 * user_status_administrative_POST,
		 */
		String methodName = filterInvocation.getRequestUrl().substring(1).replace('/', '_')
				+"_"+ authentication.getAuthorities().toArray()[0]+"_"+filterInvocation.getHttpRequest().getMethod();
		System.out.println("映射值为:"+methodName);
		Object re = ReflectUtil.useMethodByMethodName(accessDecisionService, methodName,
				filterInvocation.getHttpRequest(),authentication.getName());
		if (re != null) {
			if ((boolean) re == false) {
				// 鉴权失败
				throw new AccessDeniedException("没有权限!");
			}
		}
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
