package com.butch.greenbirdoa.mapper;

import java.util.List;

import com.butch.greenbirdoa.pojo.Jurisdiction;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface JurisdictionMapper {
    /**
     * 查询所有的Jurisdiction
     * @return 所有的Jurisdiction
     */
    public List<Jurisdiction> getAllJurisdiction();

    /**
     * 使用一个id获取对应的Jurisdiction
     * @param id
     * @return 对应的Jurisdiction
     */
    public Jurisdiction getJurisdictionById(int id);
}