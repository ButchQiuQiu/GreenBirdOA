package com.butch.spring_security_demo;

import com.butch.spring_security_demo.bean.MyResourceBean;
import com.butch.spring_security_demo.mapper.MyResourceBeanMapper;
import com.butch.spring_security_demo.mapper.MyUserBeanMapper;

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
