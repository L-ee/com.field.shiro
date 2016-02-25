package com.linan.shiro.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.linan.shiro.dao.TestDao;
import com.linan.shiro.service.TestService;

public class TestHibernate {
	
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		TestDao testDao = (TestDao) context.getBean("testDao");
		
		com.linan.shiro.model.Test test = new com.linan.shiro.model.Test();
		test.setName("ABC");
		
		testDao.saveTest(test);
		System.out.println(test.toString());
	}
	
	@Test
	public void test1(){
		ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		TestService testService = (TestService) context.getBean("testService");
		
		com.linan.shiro.model.Test test = new com.linan.shiro.model.Test();
		test.setName("ABC");
		
		testService.saveTest(test);
		System.out.println(test.toString());
	}
	
	

}
