package com.butch.greenbirdoa.controller;

import com.butch.greenbirdoa.mapper.UserMapper;
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

    @GetMapping("data/table/user")
    public String getAllUser() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(userMapper.getAllUser());
    }
}