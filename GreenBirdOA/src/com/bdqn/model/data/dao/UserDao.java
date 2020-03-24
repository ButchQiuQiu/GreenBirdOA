package com.bdqn.model.data.dao;

import com.bdqn.model.data.bean.User;

public interface UserDao{
	boolean LoginIsTrue(String user, String pwd);
	User GetUserByUser(String user);

}
