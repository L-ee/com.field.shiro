package com.linan.shiro.dao;

import com.linan.shiro.model.SysUser;

/**
 * 
 * <P>Descriptor:
 * <P>User lee
 * <P>Date 2016Äê1ÔÂ31ÈÕ
 * <P>version com.linan.shiro
 */
public interface SysUserDao {
	
	public SysUser findSysUserByName(String name) throws Exception;

}
