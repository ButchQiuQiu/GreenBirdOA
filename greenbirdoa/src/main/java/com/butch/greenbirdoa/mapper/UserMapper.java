package com.butch.greenbirdoa.mapper;

import java.util.List;
import java.util.Map;

import com.butch.greenbirdoa.pojo.User;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserMapper {
    /**
     * SpringSecurity用来验证用户的方法,使用用户名匹配用户然后框架判断密码
     * @param name 用户名
     * @return 一个用户
     */
	public User getUserByUsername(String name);
	
	/**
	 * 获取所有用户
	 * @return 用户合集
	 */
	public List<User> getUsersByUser(User user);

	/**
	 * 使用username删除一个用户
	 * @param username
	 * @return 处理结果
	 */
    public boolean deleteUserByUsername(Map<String,User> users);
}