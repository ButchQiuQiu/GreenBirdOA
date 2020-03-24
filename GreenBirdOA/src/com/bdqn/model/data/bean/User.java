package com.bdqn.model.data.bean;

public class User {
	public static String tablename="user";
	private Integer id;
	private String user;
	private String pwd;
	private String name;
	private Depart fk_depart;
	private String address;
	private Integer phone;
	private String lastsign;
	private Integer absenteeism;
	private Jurisdiction fk_jurisdiction;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String user, String pwd, String name, Depart fk_depart, String address,
			Integer phone, String lastsign, Integer absenteeism, Jurisdiction fk_jurisdiction) {
		super();
		this.id = id;
		this.user = user;
		this.pwd = pwd;
		this.name = name;
		this.fk_depart = fk_depart;
		this.address = address;
		this.phone = phone;
		this.lastsign = lastsign;
		this.absenteeism = absenteeism;
		this.fk_jurisdiction = fk_jurisdiction;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Depart getFk_depart() {
		return fk_depart;
	}
	public void setFk_depart(Depart fk_depart) {
		this.fk_depart = fk_depart;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
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
		return fk_jurisdiction;
	}
	public void setJurisdiction(Jurisdiction fk_jurisdiction) {
		this.fk_jurisdiction = fk_jurisdiction;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", user=" + user + ", pwd=" + pwd + ", name=" + name + ", fk_department="
				+ fk_depart + ", address=" + address + ", phone=" + phone + ", lastsign=" + lastsign
				+ ", absenteeism=" + absenteeism + ", fk_jurisdiction=" + fk_jurisdiction + ", hashCode()=" + hashCode()
				+ "]";
	}
	
}
