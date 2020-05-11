package com.butch.greenbirdoa.controller;

import com.butch.greenbirdoa.service.DataTableService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * datatable的CURD操作
 */
@RestController
public class DataTableController {
    @Autowired
    private DataTableService dataTableService;
    
    /**
     * 获取当前角色能获取到的用户和所有的fk
     */
    @GetMapping("data/table/user")
    public String getAllUserAndFkByUserRole() throws JsonProcessingException {
        return dataTableService.getAllUserAndFkByUserRole();
    }
}