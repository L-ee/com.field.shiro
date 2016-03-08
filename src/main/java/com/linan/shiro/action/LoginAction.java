package com.linan.shiro.action;

import com.linan.shiro.dao.SysResourceDao;
import com.linan.shiro.model.SysResource;
import com.linan.shiro.model.SysRole;
import com.linan.shiro.service.SysResourceService;
import com.linan.shiro.service.SysRoleService;
import com.linan.shiro.util.PasswordHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.linan.shiro.model.SysUser;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

/**
 * �û���¼
 * @author lee
 * 2016-01-30
 */
@Namespace("/login")
public class LoginAction extends BaceAction implements ModelDriven<SysUser>{

	private SysUser sysUser;

	@Autowired
	private SysRoleService sysRoleService;

	@Autowired
	private SysResourceService sysResourceService;

    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
	public SysUser getModel() {
		// TODO Auto-generated method stub
		if(sysUser == null){
			sysUser = new SysUser();
		}
		return sysUser;
	}
	
	@Action(value="load",results={@Result(location="/jsp/login/home.jsp",name="Lee"),
	                              @Result(name="ERROR",location = "/index.jsp",type = "redirect")})
	public String login(){
		System.out.println(sysUser.toString());
		Subject subject = SecurityUtils.getSubject();
		sysUser.setPassword(PasswordHelper.encryptPassword(sysUser.getPassword()));
		UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getUsername(), sysUser.getPassword());
		try {
			subject.login(token);
		} catch(UnknownAccountException e){
			error = "不存在该账户名";
            System.out.println(error);
            return "ERROR";
		} catch (IncorrectCredentialsException e){
			error = "账号或密码错误";
            System.out.println(error);
            return "ERROR";
		} catch (AuthenticationException e){
			error = "账号或密码错误" + e.getMessage();
            System.out.println(error);
            return "ERROR";
		}
		return "Lee";
	}

	@Action(value = "findMeum",results = {@Result(name = "SUCCESS",location = "/jsp/login/home.jsp")})
	public String getPermission(){

		Subject subject = SecurityUtils.getSubject();
		SysUser user = (SysUser) subject.getSession().getAttribute("sysuser");
		SysRole role = sysRoleService.getSysRoleById(Integer.valueOf(user.getRoleIds()));
		System.out.println(role.toString());

		List<SysResource> sysResources = sysResourceService.getSysResourceById(role.getResourceIds());

		for (SysResource s:sysResources){
			System.out.println(s.toString());
		}

		OutputJson(sysResources);

		return "SUCCESS";
	}
	
	
}
