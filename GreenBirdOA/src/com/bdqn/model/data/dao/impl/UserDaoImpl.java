package com.bdqn.model.data.dao.impl;

import java.util.List;

import com.bdqn.model.data.bean.User;
import com.bdqn.model.data.dao.UserDao;
import com.bdqn.model.data.util.BaseImpl;

public class UserDaoImpl extends BaseImpl<User> implements UserDao {

	@Override
	public boolean LoginIsTrue(String user, String pwd) {
		if(this.ExecuteQueryBySql(User.class,"select * from "+User.tablename+" where user=? and pwd=?",user,pwd).size()>0) {
			return true;
		}
		return false;
	}

	@Override
	public User GetUserByUser(String user) {
		List<User> u=this.ExecuteQueryBySql(User.class,"select * from "+User.tablename+" where user=?",user);
		if(u.size()>0) {
			return u.get(0);
		}
		return null;
	}

}
