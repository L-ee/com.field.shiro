package com.linan.shiro.dao;

import com.linan.shiro.model.SysUser;

/**
 * 
 * <P>Descriptor:
 * <P>User lee
 * <P>Date 2016��1��31��
 * <P>version com.linan.shiro
 */
public interface SysUserDao {
	
	public SysUser findSysUserByName(String name) throws Exception;

}
