package com.butch.greenbirdoa.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getLastsign() {
		return lastsign;
	}

	public void setLastsign(String lastsign) {
		this.lastsign = lastsign;
	}

	public Integer getAbsenteeism() {
		return absenteeism;
	}

	public void setAbsenteeism(Integer absenteeism) {
		this.absenteeism = absenteeism;
	}

	public Jurisdiction getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(Jurisdiction jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public Depart getDepart() {
		return depart;
	}

	public void setDepart(Depart depart) {
		this.depart = depart;
	}

	//获取权限名
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
		simpleGrantedAuthorities.add(new SimpleGrantedAuthority(this.depart.getAuthority().getName()));
		return simpleGrantedAuthorities;
	}
	//获取密码
	@Override
	public String getPassword() {
		return this.password;
	}
	//获取账号
	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	}
