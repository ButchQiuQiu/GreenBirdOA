package com.butch.greenbirdoa.pojo;

public class FLowStatus {
	public static String tablename="flowstatus";
	private Integer id;
	private String status;
	public FLowStatus() {
		super();
	}
	public FLowStatus(Integer id, String status) {
		super();
		this.id = id;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "FLowStatus [id=" + id + ", status=" + status + ", hashCode()=" + hashCode() + "]";
	}
	
}
