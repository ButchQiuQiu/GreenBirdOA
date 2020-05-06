package com.bdqn.model.actionbiz.manage;

import com.bdqn.controller.Action;

/**
 * 修改用户的某条属性
 * @author QiuQiu
 *
 */
public abstract class EditUser implements Action{
	/**
	 * 前端传过来的数据库字段名
	 */
	protected String key;
	/**
	 * 对应字段名的值
	 */
	protected String value;
	
	/**
	 * 	后端的处理是否成功
	 */
	protected boolean returnIsTrue;
}
