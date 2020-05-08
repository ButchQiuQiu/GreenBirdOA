package com.butch.greenbirdoa.config;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

/**
* AccessDecisionManager框架有3种实现,默认使用投票实现
* 鉴权决策类,默认实现是使用投票方案
*/
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {

	/**
	 * 
	 * 自定义鉴权
	 * @param authentication:调用该方法的调用者
	 * @param object:被保护的对象
	 * @param configAttributes:与object关联的配置属性,每个ConfigAttribute的getAttribute方法就是角色字符串
	 * @throws AccessDeniedException
	 * @throws InsufficientAuthenticationException
	 */
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		//由形参的authentication及用户中获取它的所有角色
		Collection<? extends GrantedAuthority> userAuthorities=authentication.getAuthorities();
		//从configAttributes中获取访问资源所需要的角色,它来自MySecurityMetadataSource的getAttributes中
		Iterator<ConfigAttribute> iterator=configAttributes.iterator();
		while(iterator.hasNext()){
			ConfigAttribute attribute=iterator.next();
			String role=attribute.getAttribute();
			//判断角色是否未登录.
			if("ROLE_NONE".equals(role)){
				if(authentication instanceof AnonymousAuthenticationToken){
					throw new BadCredentialsException("用户为登录");
				}else{
					return;
				}
			}
			//给角色匹配权限
			for (GrantedAuthority authority : userAuthorities) {
				if("ROLE_ADMIN".equals(authority.getAuthority())){
					return;
				}
				if(role.equals(authority.getAuthority())){
					return;
				}
			}
		}
		//没有匹配到能通过的权限
		throw new AccessDeniedException("你没有"+object+"的权限!");
	}

	/**
	 * 可以通过系统传过来的角色来选择是否处理这次鉴权
	 * @param attribute
	 * @return boolean
	 */
	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	/**
	 * 通过系统传过来的形参类型来选择是否处理这次鉴权
	 * @param clazz
	 * @return boolean
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("MyAccessDecisionManager的support形参"+clazz.getClass());
		return true;
	}

}
