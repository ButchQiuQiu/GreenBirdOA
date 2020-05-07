package com.butch.greenbirdoa.pojo;

import java.io.Serializable;

public class Sex implements Serializable {
	/**	
	 *	序列化
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	public Sex() {
		super();
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

	public Sex(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Sex [id=" + id + ", name=" + name + ", hashCode()=" + hashCode() + "]";
	}
	
}
