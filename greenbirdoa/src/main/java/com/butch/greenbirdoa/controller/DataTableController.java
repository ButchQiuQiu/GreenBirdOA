package com.butch.greenbirdoa.controller;

import java.util.ArrayList;
import java.util.List;

import com.butch.greenbirdoa.mapper.DepartMapper;
import com.butch.greenbirdoa.mapper.JurisdictionMapper;
import com.butch.greenbirdoa.mapper.SexMapper;
import com.butch.greenbirdoa.mapper.UserMapper;
import com.butch.greenbirdoa.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * datatable的CURD操作
 */
@RestController
public class DataTableController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SexMapper sexMapper;
    @Autowired
    private DepartMapper departMapper;
    @Autowired
    private JurisdictionMapper jurisdictionMapper;
    
    /**
     * 获取当前角色能获取到的用户和所有的fk
     */
    @GetMapping("data/table/user")
    public String getAllUserAndFkByUserRole() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Object> reJson = new ArrayList<>();
        reJson.add(sexMapper.getAllSex());
        reJson.add(departMapper.getAllDepart());
        reJson.add(jurisdictionMapper.getAllJurisdiction());
        reJson.addAll(userMapper.getAllUser());
        return objectMapper.writeValueAsString(reJson);
    }
}