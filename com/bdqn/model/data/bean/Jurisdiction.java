package com.bdqn.model.data.bean;

public class Jurisdiction {
	public static String tablename="jurisdiction";
	private Integer id;
	private String name;
	public Jurisdiction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Jurisdiction(Integer id, String name) {
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
		return "Jurisdiction [id=" + id + ", name=" + name + ", hashCode()=" + hashCode() + "]";
	}
	
}
