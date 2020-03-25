package com.bdqn.model.actionbiz.login;

import com.bdqn.controller.Action;

//没有传入值,前端请求后端查找session中的user值,是否已经登录过
public abstract class InitLogin implements Action{
	protected String userName;			  //返回用户的名字
	protected String userDepart;		  //返回用户的部门
	protected boolean userToDayIsSignin=false;//返回今天是否已签到
	protected boolean returnIsTrue=false; //返回:session中是否有user这个属性
}
