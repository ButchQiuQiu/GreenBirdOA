package com.bdqn.model.data.bean;

public class Sex {
	public static String tablename="sex";
	private Integer id;
	private String name;
	public Sex() {
		super();
		// TODO Auto-generated constructor stub
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
