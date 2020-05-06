package com.butch.greenbirdoa.mapper;


import com.butch.greenbirdoa.pojo.MyUserBean;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface MyUserBeanMapper {
    public MyUserBean selectByUsername(String name);
}