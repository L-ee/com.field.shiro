package com.linan.shiro.dao.impl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.linan.shiro.dao.TestDao;
import com.linan.shiro.model.Test;

@Repository("testDaoImpl")
public class TestDaoImpl implements TestDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveTest(Test test) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.save(test);
		session.flush();
		return true;
	}

}
