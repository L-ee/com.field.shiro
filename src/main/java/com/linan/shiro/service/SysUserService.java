package com.linan.shiro.service;

import com.linan.shiro.model.SysUser;

/**
 * 用户登录Service层
 * <P>Descriptor:
 * <P>User lee
 * <P>Date 2016年1月31日
 * <P>version com.linan.shiro
 */
public interface SysUserService {
	
	public SysUser getSysUserByName(String name) throws Exception;

}
