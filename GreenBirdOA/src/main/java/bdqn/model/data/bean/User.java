package com.bdqn.model.data.bean;

public class User {
	public static String tablename="user";
	private String user;
	private String pwd;
	private String name;
	private Sex fk_sex;
	private String address;
	private String phone;
	private Double salary;
	private String lastsign;
	private Integer absenteeism;
	private Jurisdiction fk_jurisdiction;
	private Depart fk_depart;
	
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
	public Sex getFk_sex() {
		return fk_sex;
	}
	public void setFk_sex(Sex fk_sex) {
		this.fk_sex = fk_sex;
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
	public Jurisdiction getFk_jurisdiction() {
		return fk_jurisdiction;
	}
	public void setFk_jurisdiction(Jurisdiction fk_jurisdiction) {
		this.fk_jurisdiction = fk_jurisdiction;
	}
	public Depart getFk_depart() {
		return fk_depart;
	}
	public void setFk_depart(Depart fk_depart) {
		this.fk_depart = fk_depart;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String user, String pwd, String name, Sex fk_sex, String address, String phone, Double salary,
			String lastsign, Integer absenteeism, Jurisdiction fk_jurisdiction, Depart fk_depart) {
		super();
		this.user = user;
		this.pwd = pwd;
		this.name = name;
		this.fk_sex = fk_sex;
		this.address = address;
		this.phone = phone;
		this.salary = salary;
		this.lastsign = lastsign;
		this.absenteeism = absenteeism;
		this.fk_jurisdiction = fk_jurisdiction;
		this.fk_depart = fk_depart;
	}
	@Override
	public String toString() {
		return "User [user=" + user + ", pwd=" + pwd + ", name=" + name + ", fk_sex=" + fk_sex + ", address=" + address
				+ ", phone=" + phone + ", salary=" + salary + ", lastsign=" + lastsign + ", absenteeism=" + absenteeism
				+ ", fk_jurisdiction=" + fk_jurisdiction + ", fk_depart=" + fk_depart + ", hashCode()=" + hashCode()
				+ "]";
	}
}
