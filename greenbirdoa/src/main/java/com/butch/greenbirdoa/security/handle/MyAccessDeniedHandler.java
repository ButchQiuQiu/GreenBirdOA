package com.butch.greenbirdoa.security.handle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.butch.greenbirdoa.pojo.ResponseBean;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
 * 鉴权失败后的处理程序.
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    /**
     * AccessDeniedException接受鉴权处理的异常
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // 返回403表示服务器理解但是拒接请求
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        // 设置返回格式为json
        response.setContentType("application/json;charset=UTF-8");
        // 获得rsp的writer
        PrintWriter out = response.getWriter();
        // 去除异常的信息存入ResponseBean并且发送给前端
        ResponseBean info = new ResponseBean(500, accessDeniedException.getMessage(), null);
        // 通过jackson解析并且发送ResponseBean实例
        out.write(new ObjectMapper().writeValueAsString(info));
        // 刷新并且关闭writer
        out.flush();
        out.close();
    }
}