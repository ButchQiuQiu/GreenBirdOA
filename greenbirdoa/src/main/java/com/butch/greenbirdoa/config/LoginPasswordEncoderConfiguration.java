package com.butch.greenbirdoa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * config类,可以在装配时切换指定实现
 * 
 * anther:qiuqiu 密码加密类导入Encoder接口
 * 只有自定义才能不加密
 */
@Configuration
public class LoginPasswordEncoderConfiguration implements PasswordEncoder{

    /**
     * 没有密码保护的PasswordEncoder
     * @return
     */
    @Bean
    public PasswordEncoder NoPassWordEncoder(){
        return this;
    }

    /**
     * 使用BCryptPasswordEncoder密码保护的PasswordEncoder
     * @return
     */
    @Bean
    public PasswordEncoder BCryptPasswordEncoder(){
        return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
    }

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