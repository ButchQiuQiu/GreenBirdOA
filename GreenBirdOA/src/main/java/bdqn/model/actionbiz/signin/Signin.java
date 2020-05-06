package com.bdqn.model.actionbiz.signin;

import com.bdqn.controller.Action;
//传入一个用户签到的命令,使用session中的user作为凭借;
public abstract class Signin implements Action {
	
	protected boolean returnIsTrue; //签到成功后返回true
}
