package com.butch.greenbirdoa;

import javax.sql.DataSource;

import com.butch.greenbirdoa.mapper.SexMapper;
import com.butch.greenbirdoa.mapper.UserMapper;
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
	DataSource ds;
	
	@Test
	void contextLoads() {
		System.out.println(ds.getClass());
	}
	//加密密码
	@Test
    void pwd() {
        System.out.println(new BCryptPasswordEncoder().encode(""));
    }

}
