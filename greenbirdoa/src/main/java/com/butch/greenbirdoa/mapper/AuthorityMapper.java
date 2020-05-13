package com.butch.greenbirdoa.mapper;

import com.butch.greenbirdoa.pojo.Authority;

import org.apache.ibatis.annotations.Mapper;

/**
 * AuthorityMapper
 */
@Mapper
public interface AuthorityMapper {
    public Authority getAuthorityById(int id);
}