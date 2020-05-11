package com.butch.greenbirdoa.security.handle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 * LoginFailedHandle 登录验证失败后的自定义处理
 */
@Component
public class LoginFailedHandle implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
        // 登录失败后的处理
        PrintWriter writer = response.getWriter();
        // 添加jackson
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>();
        map.put("returnIsTrue", "false");
        writer.write(mapper.writeValueAsString(map));
        writer.flush();
        writer.close();
    }

}