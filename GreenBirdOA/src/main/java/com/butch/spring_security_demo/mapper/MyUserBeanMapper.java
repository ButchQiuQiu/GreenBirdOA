package com.butch.spring_security_demo.mapper;


import com.butch.spring_security_demo.bean.MyUserBean;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface MyUserBeanMapper {
    public MyUserBean selectByUsername(String name);
}