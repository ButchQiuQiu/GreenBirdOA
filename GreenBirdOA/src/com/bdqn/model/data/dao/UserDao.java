package com.bdqn.model.data.dao;

import com.bdqn.model.data.bean.User;

public interface UserDao{
	/**
	 * @param user 用户名
	 * @param pwd 密码
	 * @return 用户名和密码能否匹配到此用户
	 */
	boolean LoginIsTrue(String user, String pwd);
	
	/**
	 * @param user 用户名(从session中提取)
	 * @return 这个用户的所有信息
	 */
	User GetUserByUser(String user);
	
	/**
	 * @param 用户名
	 * @return 是否签到成功
	 */
	boolean SetSignin(String user);
	/**
	 * 	检查并设置所有人的签到
	 */
	void setAllSign();
}
