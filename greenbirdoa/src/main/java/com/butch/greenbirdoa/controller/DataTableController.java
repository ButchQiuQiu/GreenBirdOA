package com.butch.greenbirdoa.controller;

import com.butch.greenbirdoa.pojo.User;
import com.butch.greenbirdoa.service.DataTableService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
     * 获取用户能查阅的角色
     * @param authentication 当前用户   
     * @return               json字符串:处理的结果
     * @throws JsonProcessingException
     */
    @GetMapping()
    public String getAllUserAndFkByUserRole(Authentication authentication) throws JsonProcessingException {
        return dataTableService.getAllUserAndFkByUserRole(authentication.getName());
    }

    /**
     * 删除角色
     * @param authentication 当前用户
     * @param username       需要操作的用户名
     * @return               json字符串:处理的结果
     * @throws JsonProcessingException
     */
    @DeleteMapping()
    public String deleteUserByUsername(Authentication authentication,String username) throws JsonProcessingException {
        return dataTableService.deleteUserByUsername(authentication.getName(),username);
    }

    /**
     * 修改角色
     * 
     * @param authentication 当前用户
     * @param username       目标用户username
     * @param column         需要修改的字段
     * @param value          需要修改的值
     * @return               json字符串:处理的结果
     * @throws JsonProcessingException
     */
    @PatchMapping()
    public String updateUserByUserMap(Authentication authentication, String username, String column, String value)
            throws JsonProcessingException {
        return dataTableService.updateUserByUserMap(authentication.getName(), username, column, value);
    }

    /**
     * 添加以为用户
     * 
     * @param authentication 当前用户
     * @param targetUser     添加的用户
     * @return               json字符串:处理的结果
     * @throws JsonProcessingException
     */
    @PostMapping()
    public String createUserByUser(Authentication authentication, @RequestBody User user)
            throws JsonProcessingException {
        return dataTableService.insertUserByUserMap(authentication.getName(),user);
    }
}