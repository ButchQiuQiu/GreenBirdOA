package com.butch.greenbirdoa.security.handle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 鉴权失败后的处理程序.
 * 
 * 明天把springBoot的版本降低成稳定版
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
            System.out.println("鉴权失败111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
	}

}