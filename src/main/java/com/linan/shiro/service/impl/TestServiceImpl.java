package com.linan.shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linan.shiro.dao.TestDao;
import com.linan.shiro.model.Test;
import com.linan.shiro.service.TestService;

@Service("testServiceImpl")
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestDao testDao;

	public TestDao getTestDao() {
		return testDao;
	}

	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}

	@Override
	public boolean saveTest(Test test) {
		// TODO Auto-generated method stub
		testDao.saveTest(test);
		return true;
	}

}
