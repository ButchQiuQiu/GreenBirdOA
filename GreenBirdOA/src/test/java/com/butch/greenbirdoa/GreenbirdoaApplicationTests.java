package com.butch.greenbirdoa;

import com.butch.greenbirdoa.mapper.MyResourceBeanMapper;
import com.butch.greenbirdoa.mapper.UserMapper;
import com.butch.greenbirdoa.pojo.MyResourceBean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class GreenbirdoaApplicationTests {

	@Autowired 
	UserMapper UserMapper;
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
	@Test
    void pwd() {
        System.out.println(new BCryptPasswordEncoder().encode(""));
    }

}
