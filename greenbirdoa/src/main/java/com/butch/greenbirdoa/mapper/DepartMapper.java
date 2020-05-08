package com.butch.greenbirdoa.mapper;

import java.util.List;

import com.butch.greenbirdoa.pojo.Depart;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface DepartMapper {
    /**
     * 查询所有的Depart
     * @return 所有的Depart
     */
    public List<Depart> getAllDepart();

    /**
     * 使用一个id获取对应的Depart
     * @param id
     * @return 对应的Depart
     */
    public Depart getDepartById(int id);
}