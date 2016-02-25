package com.linan.shiro.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.linan.shiro.model.SysUser;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户登录
 * @author lee
 * 2016-01-30
 */
@Namespace("/login")
public class LoginAction extends BaceAction implements ModelDriven<SysUser>{

	private SysUser sysUser;
	
	@Override
	public SysUser getModel() {
		// TODO Auto-generated method stub
		if(sysUser == null){
			sysUser = new SysUser();
		}
		return sysUser;
	}
	
	@Action(value="load",results={@Result(location="/jsp/login/home.jsp",name="Lee")})
	public String login(){
		String error = null;
		System.out.println(sysUser.toString());
		System.out.println("===========login:begin================");
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getUsername(), sysUser.getPassword());
		
		try {
			subject.login(token);
		} catch(UnknownAccountException e){
			error = "用户名或密码错误";
		} catch (IncorrectCredentialsException e){
			error = "用户名或密码错误";
		} catch (AuthenticationException e){
			error = "其他错误" + e.getMessage();
		}

		return "Lee";
	}


	
	
}
