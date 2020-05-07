package com.butch.greenbirdoa.mapper;


import com.butch.greenbirdoa.pojo.User;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface MyUserBeanMapper {
    public User GetUserByUsername(String name);
}