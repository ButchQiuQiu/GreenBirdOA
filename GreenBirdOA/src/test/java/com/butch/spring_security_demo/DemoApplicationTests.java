package com.butch.spring_security_demo;

import com.butch.greenbirdoa.mapper.MyResourceBeanMapper;
import com.butch.greenbirdoa.mapper.MyUserBeanMapper;
import com.butch.greenbirdoa.pojo.MyResourceBean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	MyUserBeanMapper myUserBeanMapper;
	@Autowired
	MyResourceBeanMapper myResourceBeanMapper ;
	
	@Test
	void contextLoads() {
		// System.out.println(myUserBeanMapper.selectByUsername("super").getPassword());
		for (MyResourceBean myResourceBean : myResourceBeanMapper.selectAllResource()) {
			System.out.println(myResourceBean.toString());
		}
				
	}
	//加密密码
	public static String generatePassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
	}

	@Test
    void pwd() {
        System.out.println(generatePassword("pwd"));
    }

}
