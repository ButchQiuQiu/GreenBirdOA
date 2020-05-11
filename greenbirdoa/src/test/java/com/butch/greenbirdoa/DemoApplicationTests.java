package com.butch.greenbirdoa;

import javax.sql.DataSource;

import com.butch.greenbirdoa.mapper.DepartMapper;
import com.butch.greenbirdoa.mapper.JurisdictionMapper;
import com.butch.greenbirdoa.mapper.SexMapper;
import com.butch.greenbirdoa.mapper.UserMapper;
import com.butch.greenbirdoa.service.DataTableService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	UserMapper userMapper;

	@Autowired
	SexMapper sexMapper;

	@Autowired
	DepartMapper departMapper;

	@Autowired
	JurisdictionMapper jurisdictionMapper;

	@Autowired
	DataTableService dataTableService;

	@Test
	void contextLoads() throws JsonProcessingException {
		System.out.println(userMapper.getUserByUsername("Qiu123456").getFk_depart().getId());
		System.out.println(userMapper.getUsersByUser(userMapper.getUserByUsername("Qiu12345629")));
	}
	//使用BCryptPasswordEncoder加密密码
	@Test
    void pwd() {
        System.out.println(new BCryptPasswordEncoder().encode(""));
	}
	

}
