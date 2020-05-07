package com.butch.greenbirdoa.mapper;
/**
 * 资源类Mapper
 */

import java.util.List;

import com.butch.greenbirdoa.pojo.MyResourceBean;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyResourceBeanMapper {
    public List<MyResourceBean> selectAllResource();
}