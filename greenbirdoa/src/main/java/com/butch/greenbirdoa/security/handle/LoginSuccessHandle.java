package com.butch.greenbirdoa.security.handle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * LoginSuccessHandle 
 * 登录验证成功后的处理
 */
@Component
public class LoginSuccessHandle implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        System.out.println("登录成功了");
        // 登录成功后的处理
        PrintWriter writer = response.getWriter();
        // 添加jackson
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>();
        map.put("returnIsTrue", "true");
        writer.write(mapper.writeValueAsString(map));
        writer.flush();
        writer.close();
    }
}