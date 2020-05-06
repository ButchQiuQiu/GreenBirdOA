package com.butch.spring_security_demo.mapper;
/**
 * 资源类Mapper
 */

import java.util.List;

import com.butch.spring_security_demo.bean.MyResourceBean;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyResourceBeanMapper {
    public List<MyResourceBean> selectAllResource();
}