package com.butch.greenbirdoa.pojo;

import java.io.Serializable;

public class Depart implements Serializable {
	
	/**
	 *	二级缓存序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Authority fk_authority;

	public Depart() {
	}

	public Depart(Integer id, String name, Authority fk_authority) {
		this.id = id;
		this.name = name;
		this.fk_authority = fk_authority;
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

	public Authority getFk_authority() {
		return fk_authority;
	}

	public void setFk_authority(Authority fk_authority) {
		this.fk_authority = fk_authority;
	}

	@Override
	public String toString() {
		return "Depart [fk_authority=" + fk_authority + ", id=" + id + ", name=" + name + "]";
	}

	
	
}
