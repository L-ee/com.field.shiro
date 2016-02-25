package com.linan.shiro.test;

import javax.naming.AuthenticationException;

import junit.framework.Assert;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.linan.shiro.dao.TestDao;

public class AlphaShiro {
	
	@Test
	public void test() throws AuthenticationException{
		
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager manager = factory.getInstance();
		SecurityUtils.setSecurityManager(manager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("lisi","123");
		try {
			subject.login(token);
		} catch (org.apache.shiro.authc.AuthenticationException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		
		
		Assert.assertEquals(true, subject.isAuthenticated());
		
		subject.logout();
		
		
	}
	
	@Test
	public void testJdbc(){
		
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
		
		SecurityManager manager = factory.getInstance();
		
		SecurityUtils.setSecurityManager(manager);
		
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		
		subject.login(token);
		
		Assert.assertEquals(true, subject.isAuthenticated());
		
	}
	
	@Test
	public void testHibernate(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestDao testDao = (TestDao) context.getBean("testDao");
		
		
		
	}
	

}
