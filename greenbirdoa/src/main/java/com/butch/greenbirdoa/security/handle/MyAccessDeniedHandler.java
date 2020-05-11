package com.butch.greenbirdoa.security.handle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
 * 鉴权失败后的处理程序.
 * 
 * 明天把springBoot的版本降低成稳定版
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {

	/**
	 * 鉴权失败后返回{"authority", "false"}数据,表示用户权限不足服务器拒绝请求
	 */
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
			PrintWriter writer = response.getWriter();
			Map<String, String> hashMap = new HashMap<String,String>();
			hashMap.put("authority", "false");
			String writeValueAsString = new ObjectMapper().writeValueAsString(hashMap);
			writer.write(writeValueAsString);
			writer.flush();
			writer.close();
	}

}