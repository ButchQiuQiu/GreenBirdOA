package com.bdqn.model.data.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.bdqn.model.actionbiz.signin.Signin;
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

	@Override
	public boolean SetSignin(String user) {
	    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		return this.ExecuteUpdateBySql("update  user set lastsign=? where user=?",ft.format(new Date()),user);
	}

	@Test
	@Override
	public void setAllSign() {
		//把所有未签到的缺勤数加1
		this.ExecuteUpdateBySql("update user set absenteeism=absenteeism+1 where lastsign='未签到'");
		//把所有签到的人的状态改为未签到
		this.ExecuteUpdateBySql("update user set lastsign='未签到'");
	}

}
