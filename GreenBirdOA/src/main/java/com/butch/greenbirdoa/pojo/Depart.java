package com.butch.greenbirdoa.pojo;

public class Depart {
	public static String tablename="depart";
	private Integer id;
	private String name;
	public Depart() {
		super();
	}
	public Depart(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", hashCode()=" + hashCode() + "]";
	}
	
}
