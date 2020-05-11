package com.butch.greenbirdoa.service;

import java.util.ArrayList;
import java.util.List;

import com.butch.greenbirdoa.mapper.DepartMapper;
import com.butch.greenbirdoa.mapper.JurisdictionMapper;
import com.butch.greenbirdoa.mapper.SexMapper;
import com.butch.greenbirdoa.mapper.UserMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataTableService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SexMapper sexMapper;
    @Autowired
    private DepartMapper departMapper;
    @Autowired
    private JurisdictionMapper jurisdictionMapper;
    public String getAllUserAndFkByUserRole() throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        List<Object> reJson = new ArrayList<>();
        reJson.add(sexMapper.getAllSex());
        reJson.add(departMapper.getAllDepart());
        reJson.add(jurisdictionMapper.getAllJurisdiction());
        reJson.addAll(userMapper.getAllUser());
        return objectMapper.writeValueAsString(reJson);
    }
}