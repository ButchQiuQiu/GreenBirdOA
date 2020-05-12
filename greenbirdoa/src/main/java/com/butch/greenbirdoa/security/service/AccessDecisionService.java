package com.butch.greenbirdoa.security.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

/**
 * 验证用户是否能使用这个url的权利,目前主要用于用户的增删改其他用户操作.
 * 
 * 由鉴权中心MyAccessDecisionManager通过反射分发url权限组合映射对应的处理方法.
 * 所有的方法返回值都是boolean类型,代表鉴权是否通过
 * 
 * 转换规则:URL:/user/status 请求类型为post 角色为administrative转换成
 * 对应方法名:user_status_administrative_POST
 * 
 * 参数为HttpRequest,可以获取前端传递的参数比如获取想要修改的username. myUsername为当前用户的username. 
 * 删改只需要目标username鉴权即可,增加鉴权的目标的信息直接从表单中取出
 * 
 * 目前项目需求比较低,mybatis的动态sql就能实现权限操作. 
 * 大型高并发项目可以启用请求鉴权减轻服务器的io压力.
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
    /**
     * 
     */
    public boolean data_table_user_administrative_DELETE(HttpServletRequest req,String myUsername){
        System.out.println("拦截到管理层"+myUsername);
        return true;
    }
    public boolean data_table_user_personnel_DELETE(HttpServletRequest req,String myUsername){
        
        return true;
    }
    public boolean data_table_user_general_DELETE(HttpServletRequest req,String myUsername){
        
        return true;
    }
    
    //修改前鉴权----------------------------------------------------------
    
    

    //增加前鉴权-----------------------------------------------------------
    
    
}