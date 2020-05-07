package com.butch.greenbirdoa.mapper;

import java.util.List;

import com.butch.greenbirdoa.pojo.Sex;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SexMapper {
    public List<Sex> getAllUser();
    public Sex getSexById();
}