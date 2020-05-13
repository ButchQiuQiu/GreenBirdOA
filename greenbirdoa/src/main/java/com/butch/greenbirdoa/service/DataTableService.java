package com.butch.greenbirdoa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.butch.greenbirdoa.mapper.AuthorityMapper;
import com.butch.greenbirdoa.mapper.DepartMapper;
import com.butch.greenbirdoa.mapper.JurisdictionMapper;
import com.butch.greenbirdoa.mapper.SexMapper;
import com.butch.greenbirdoa.mapper.UserMapper;
import com.butch.greenbirdoa.pojo.User;
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
    public String getAllUserAndFkByUserRole(String username) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        List<Object> reJson = new ArrayList<>();
        reJson.add(sexMapper.getAllSex());
        reJson.add(departMapper.getAllDepart());
        reJson.add(jurisdictionMapper.getAllJurisdiction());
        reJson.addAll(userMapper.getUsersByUser(userMapper.getUserByUsername(username)));
        return objectMapper.writeValueAsString(reJson);
    }

    public String deleteUserByUsername(String myUsername,String targetUsername) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = new HashMap<String,String>();
        Map<String, User> userMap = new HashMap<String,User>();
        userMap.put("myUser", userMapper.getUserByUsername(myUsername));
        userMap.put("targetUser", userMapper.getUserByUsername(targetUsername));
        map.put("returnIsTrue",String.valueOf(userMapper.deleteUserByUserMap(userMap)));
        return objectMapper.writeValueAsString(map);
    }

    public String updateUserByUserMap(String myUsername,String targetUsername,String column,String value)
        throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = new HashMap<String,String>();
        Map<String, Object> userMap = new HashMap<String,Object>();
        userMap.put("myUser", userMapper.getUserByUsername(myUsername));
        userMap.put("targetUser", userMapper.getUserByUsername(targetUsername));
        userMap.put("column", column);
        userMap.put("value", value);
        map.put("returnIsTrue",String.valueOf(userMapper.updateUserByUserMap(userMap)));
        return objectMapper.writeValueAsString(map);
    }

    public String insertUserByUserMap(String myUsername,User targetUser) throws JsonProcessingException {
        //前台传递过来的user没有详细的部门角色信息需要查询设置
        targetUser.setFk_depart(departMapper.getDepartById(targetUser.getFk_depart().getId()));;
        
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = new HashMap<String,String>();
        Map<String, User> userMap = new HashMap<String,User>();
        userMap.put("myUser", userMapper.getUserByUsername(myUsername));
        userMap.put("targetUser", targetUser);
        map.put("returnIsTrue",String.valueOf(userMapper.insertUserByUsers(userMap)));
        return objectMapper.writeValueAsString(map);
    }
}