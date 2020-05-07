package com.butch.greenbirdoa.pojo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

 /**
  * 用户表实现UserDetails接口
  */
public class User implements UserDetails {
	/**	
	 *	序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String name;
	private Sex sex;
	private String address;
	private String phone;
	private Double salary;
	private String lastsign;
	private Integer absenteeism;
	private Jurisdiction jurisdiction;
	private Depart depart;

	public User() {
	}

	public User(String username, String password, String name, Sex sex, String address, String phone, Double salary,
			String lastsign, Integer absenteeism, Jurisdiction jurisdiction, Depart depart) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.salary = salary;
		this.lastsign = lastsign;
		this.absenteeism = absenteeism;
		this.jurisdiction = jurisdiction;
		this.depart = depart;
	}

	@Override
	public String toString() {
		return "User [absenteeism=" + absenteeism + ", address=" + address + ", depart=" + depart + ", jurisdiction="
				+ jurisdiction + ", lastsign=" + lastsign + ", name=" + name + ", password=" + password + ", phone="
				+ phone + ", salary=" + salary + ", sex=" + sex + ", username=" + username + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
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
	
	}
