package com.butch.greenbirdoa.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * anther:qiuqiu 密码加密类导入Encoder接口
 * 只有自定义才能不加密
 */
public class LoginPasswordEncoder implements PasswordEncoder{
    
    @Override
    public String encode(CharSequence rawPassword) {
        System.out.println("密码是:"+rawPassword.toString());
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        System.out.println("密码对比:"+rawPassword+"和"+encodedPassword);
        return rawPassword.toString().equals(encodedPassword);
    }

    
}