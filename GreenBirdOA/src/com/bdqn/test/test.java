package com.bdqn.test;

import com.bdqn.model.data.bean.User;
import com.bdqn.model.data.dao.impl.UserDaoImpl;

public class test {
	public static void main(String[] args) {
		System.out.println(new UserDaoImpl().LoginIsTrue("Qiu123456", "123456"));
	}
}
