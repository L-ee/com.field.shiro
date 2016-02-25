package com.linan.shiro.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.linan.shiro.dao.SysUserDao;
import com.linan.shiro.model.SysUser;

/**
 * 
 * <P>Descriptor:
 * <P>User lee
 * <P>Date 2016年1月31日
 * <P>version com.linan.shiro
 */
@Repository("sysUserDao")
public class SysUserDaoImpl implements SysUserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SysUser findSysUserByName(String name) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM SysUser s WHERE s.username = '" + name + "'");
		if (query == null && query.list().size() < 0){
			throw new Exception("用户不存在");
		}
		return (SysUser) query.list().get(0);
	}

}
