package com.butch.greenbirdoa.service;

import java.util.HashMap;
import java.util.Map;

import com.butch.greenbirdoa.mapper.UserMapper;
import com.butch.greenbirdoa.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 获取用户的信息Service
 */
@Service
public class UserDetailService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 
     * @param name 用户名
     * @return  详细json字符串
     * @throws JsonProcessingException json转换错误
     */
    public String getUserDeprtAndNameJson(String name) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>();
        User user = userMapper.getUserByUsername(name);
        map.put("returnIsTrue", "true");
        map.put("userDepart", user.getFk_depart().getName());
        map.put("userName", user.getName());
        return objectMapper.writeValueAsString(map);
    }

    
}