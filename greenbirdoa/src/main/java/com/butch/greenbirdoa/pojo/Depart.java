package com.butch.greenbirdoa.pojo;

import java.io.Serializable;

public class Depart implements Serializable {
	
	/**
	 *	二级缓存序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Authority authority;

	public Depart() {
	}

	public Depart(Integer id, String name, Authority authority) {
		this.id = id;
		this.name = name;
		this.authority = authority;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Depart [authority=" + authority + ", id=" + id + ", name=" + name + "]";
	}
	
}
