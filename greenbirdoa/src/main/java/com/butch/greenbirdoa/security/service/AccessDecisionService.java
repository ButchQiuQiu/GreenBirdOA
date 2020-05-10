package com.butch.greenbirdoa.security.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

/**
 * 验证用户是否能使用这个url的权利,目前主要用于用户的增删改其他用户操作.
 * 
 * 由鉴权中心MyAccessDecisionManager通过反射分发url权限组合映射对应的处理方法.
 * 所有的方法返回值都是boolean类型,代表鉴权是否通过
 * 
 * 方法名是最近的url+权限名. 比如用户权限名为administrative. URL为:localhost:8080/xxx/xxx/delete,
 * 那么对应的鉴权方法名为delete_adminstrative
 * 
 * 参数为HttpRequest,可以获取前端传递的参数
 * 
 */
@Service
public class AccessDecisionService {
    //测试
    public boolean user_status(HttpServletRequest req){
        System.out.println("检查status权限100%失败");
        return false;
    }
    //删除前鉴权----------------------------------------------------------
    public boolean delete_adminstrative(HttpServletRequest req){
        return false;
    }
    public boolean delete_personnel(HttpServletRequest req){
        
        return false;
    }
    public boolean delete_general(HttpServletRequest req){
        
        return false;
    }
    
    //修改前鉴权----------------------------------------------------------
    public boolean update_adminstrative(HttpServletRequest req){
        
        return false;
    }
    public boolean update_personnel(HttpServletRequest req){
        
        return false;
    }
    public boolean update_general(HttpServletRequest req){
        
        return false;
    }
    

    //增加前鉴权-----------------------------------------------------------
    public boolean insert_adminstrative(HttpServletRequest req){
        
        return false;
    }

    public boolean insert_personnel(HttpServletRequest req){
        
        return false;
    }

    public boolean insert_general(HttpServletRequest req){
        
        return false;
    }
    
}