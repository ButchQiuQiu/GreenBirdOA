package com.butch.greenbirdoa.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import com.butch.greenbirdoa.mapper.UserMapper;
import com.butch.greenbirdoa.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 管理用户登录和验证权限的Controller
 */
@RestController()
public class UserStatusControoler {
    @Autowired
    UserMapper userMapper;

    /**
     * 前端需要的信息:姓名和部门
     * @param authentication
     * @return 当前用户登录的信息
     * @throws JsonProcessingException json转换失败
     */
    @PostMapping(value = "/get_user_status")
    public String getUserStatus(Authentication authentication) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>();
        System.out.println(authentication);
        User user = userMapper.getUserByUsername(authentication.getName());
        map.put("returnIsTrue", "true");
        map.put("userDepart", user.getDepart().getName());
        map.put("userName", user.getName());
        return objectMapper.writeValueAsString(map);
    }
    
}