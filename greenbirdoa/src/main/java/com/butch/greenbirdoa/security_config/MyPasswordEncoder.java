package com.butch.greenbirdoa.security_config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * anther:qiuqiu 密码加密类导入Encoder接口
 * 只有自定义才能不加密
 */
public class MyPasswordEncoder implements PasswordEncoder{
    
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return false;
    }

    
}