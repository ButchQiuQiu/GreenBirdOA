package com.butch.greenbirdoa.security;

import com.butch.greenbirdoa.mapper.UserMapper;
import com.butch.greenbirdoa.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

/**
 * 实现UserDetailsService类,可以自定义验证逻辑.用于security自带的DaoAuthenticationProvider.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserMapper mapper;
    
    /** 
     * @param username:用户名
     * @return 返回一个实现UserDetails接口的实例(用户),不能返回NUll,如果为Null则需要手动抛出异常.
     * @throws UsernameNotFoundException("自定义参数")
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("检查登录");
        User userBean=mapper.getUserByUsername(username);
        if(userBean==null){
            throw new UsernameNotFoundException("数据库中没有此用户");
        }
        System.out.println("账号:"+userBean.getUsername()+"密码:"+userBean.getPassword());
        return userBean;
    }
}
