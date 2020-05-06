package com.butch.greenbirdoa.pojo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @author butch
 * 用户bean,实现了UserDetails接口可以让springsecurity自动验证和鉴权
 * 实现UserDetails接口security可以获得权限和用户信息,用户也可以获取接口指定的各种信息.
 */

//注入spring
@Component
public class MyUserBean implements UserDetails{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String username;
    private String password;
    private String roles;

    public MyUserBean() {
    }

    public MyUserBean(Long id, String name, String username, String password, String roles) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    //获取所有权限由接口定义
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return null;
	}

    //获取password由接口定义
	@Override
	public String getPassword() {
		return this.password;
	}

    //获取用户名由接口定义
	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() { 
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
    
}