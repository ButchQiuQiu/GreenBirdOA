package com.butch.greenbirdoa;

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
		System.out.println(dataTableService.deleteUserByUsername("Qiu1234561111117","Qiu1234561111122"));
	}
	//使用BCryptPasswordEncoder加密密码
	@Test
    void pwd() {
        System.out.println(new BCryptPasswordEncoder().encode(""));
	}
	

}
