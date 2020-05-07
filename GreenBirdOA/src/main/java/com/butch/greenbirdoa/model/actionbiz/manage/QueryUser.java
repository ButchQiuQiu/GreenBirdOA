package com.bdqn.model.actionbiz.manage;

import com.bdqn.controller.Action;
import com.bdqn.model.data.bean.Depart;
import com.bdqn.model.data.bean.Jurisdiction;

public abstract class QueryUser implements Action {
	//查询 前端需要user表除了id之外所有的属性,键名为数据库表中的字段名
	protected String user;
	protected String pwd;
	protected String name;
	protected Depart fk_depart;
	protected String address;
	protected Integer phone;
	protected String lastsign;
	protected Integer absenteeism;
	protected Jurisdiction fk_jurisdiction;
	
}
