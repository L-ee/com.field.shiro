package com.linan.shiro.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.linan.shiro.model.SysUser;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/user")
public class SysUserAction extends BaceAction implements ModelDriven<SysUser> {
	
	private SysUser user;

	@Override
	public SysUser getModel() {
		// TODO Auto-generated method stub
		if(user == null){
			user = new SysUser();
		}
		return user;
	}
	
	@Action("add")
	public String addUser(){
		return SUCCESS;
	}
	
	@Action("findPermission")
	public String findPermission(){
		Subject subject = SecurityUtils.getSubject();
		boolean hasRole = subject.hasRole("admin");
		System.out.println("该用户的角色是：" + hasRole);
		return SUCCESS;
	}

}
