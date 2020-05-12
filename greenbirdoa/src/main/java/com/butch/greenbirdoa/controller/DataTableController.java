package com.butch.greenbirdoa.controller;

import com.butch.greenbirdoa.service.DataTableService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * datatable的CURD操作
 */
@RestController
@RequestMapping("data/table/user")
public class DataTableController {
    @Autowired
    private DataTableService dataTableService;
    
    /**
     * 获取当前角色能获取到的用户和所有的fk
     */
    @GetMapping()
    public String getAllUserAndFkByUserRole(Authentication authentication) throws JsonProcessingException {
        return dataTableService.getAllUserAndFkByUserRole(authentication.getName());
    }

    /**
     * 删除目标角色由mybatis动态sql鉴权
     */
    @DeleteMapping()
    public String deleteUserByUsername(Authentication authentication,String username) throws JsonProcessingException {
        return dataTableService.deleteUserByUsername(authentication.getName(),username);
    }
    
}