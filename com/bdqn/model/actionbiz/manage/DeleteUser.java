package com.bdqn.model.actionbiz.manage;

import com.bdqn.controller.Action;

public abstract class DeleteUser implements Action{
	/**
	 * 需要删除的用户账号
	 */
	protected String user;
	/**
	 * json对象:处理是否成功
	 */
	protected boolean returnIsTrue=false;
	
}
