package com.linan.shiro.service;

import com.linan.shiro.model.SysUser;

/**
 * �û���¼Service��
 * <P>Descriptor:
 * <P>User lee
 * <P>Date 2016��1��31��
 * <P>version com.linan.shiro
 */
public interface SysUserService {
	
	public SysUser getSysUserByName(String name) throws Exception;

}
