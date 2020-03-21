package com.bdqn.model.actionbiz.login;

import com.bdqn.controller.Action;
//前端所需要留下的抽象父类,完成后的url为抽象类所在的包名(这个例子是login)外加下划线加留下的抽象类名加.do;
//比如这个url为login_UserIsTrue.do,前端调用这个url也需要区分大小写;

//接入Action接口表示这是个action
public abstract class UserIsTrue implements Action{
	//只有一个json对象,它的两个属性是传入用户账号密码
	protected String user; //账号
	protected String pwd;	//密码
	
	//需要返回的json对象只有一个布尔属性,代表这个用户是否存在.
	protected boolean returnIsTrue;
}
