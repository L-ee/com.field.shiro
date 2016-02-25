package com.linan.shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linan.shiro.dao.SysUserDao;
import com.linan.shiro.model.SysUser;
import com.linan.shiro.service.SysUserService;

/**
 * 
 * <P>Descriptor:
 * <P>User lee
 * <P>Date 2016Äê1ÔÂ31ÈÕ
 * <P>version com.linan.shiro
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
	
	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public SysUser getSysUserByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return sysUserDao.findSysUserByName(name);
	}



}
