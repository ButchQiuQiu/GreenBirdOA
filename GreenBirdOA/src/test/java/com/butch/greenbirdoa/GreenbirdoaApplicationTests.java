package com.butch.greenbirdoa;

import com.butch.greenbirdoa.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class GreenbirdoaApplicationTests {

	@Autowired 
	UserMapper UserMapper;
	
	@Test
	void contextLoads() {
		System.out.println(UserMapper.getUserByUsername("Qiu123456").toString());
	}
	//加密密码
	@Test
    void pwd() {
        System.out.println(new BCryptPasswordEncoder().encode(""));
    }

}
