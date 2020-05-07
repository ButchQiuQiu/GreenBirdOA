package com.butch.greenbirdoa.mapper;

import java.util.List;

import com.butch.greenbirdoa.pojo.User;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserMapper {
    /**
     * SpringSecurity用来验证用户的方法,使用用户名匹配用户然后框架判断密码
     * @param name 用户名
     * @return 一个用户
     */
    //已经mapper
    public User getUserByUsername(String name);
    /**
	 * @param user 用户名
	 * @param pwd 密码
	 * @return 用户名和密码能否匹配到此用户
	 */
	boolean loginIsTrue(String user, String pwd);
	
	/**
	 * @param user 用户名(从session中提取)
	 * @return 这个用户的所有信息
	 */
	User getUserByUser(String user);
	
	/**
	 * @param 用户名
	 * @return 是否签到成功
	 */
	boolean setSignin(String user);
	/**
	 * 	检查并设置所有人的签到
	 */
	void setAllSign();

	/**
	 * 获取用户
	 * @param sql语句条件
	 * @return 用户合集
	 */
	List<User> getAllUser(String sql);
	/**
	 * 添加一名用户
	 * @param user:前端传过来的数据合成的一个user
	 * @return 处理的结果
	 */
	boolean addUser(User user);
	
	/**
	 *删除一名用户
	 * @param user 前端传过来的用户账号
	 * @return	处理的结果
	 */
	boolean deleteUser(String user);

	/**
	 * 更改用户的一项属性
	 * @param key
	 * @param value
	 * @return 处理的结果
	 */
	boolean editUser(String user,String key, String value);
}