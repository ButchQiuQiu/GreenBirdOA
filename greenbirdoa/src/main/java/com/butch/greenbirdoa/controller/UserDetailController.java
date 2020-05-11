package com.butch.greenbirdoa.controller;

import com.butch.greenbirdoa.service.UserDetailService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理用户登录和验证权限的Controller
 */
@RestController()

public class UserDetailController {
    @Autowired
    UserDetailService userDetailService;

    /**
     * 前端需要的信息:姓名和部门
     * @param authentication
     * @return 当前用户登录的信息
     * @throws JsonProcessingException json转换失败
     */
    @PostMapping("/user/status")
    public String getUserStatus(Authentication authentication) throws JsonProcessingException {
        return userDetailService.getUserDeprtAndNameJson(authentication.getName());
    }
    
    
}