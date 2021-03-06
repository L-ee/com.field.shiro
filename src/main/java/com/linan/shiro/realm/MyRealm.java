package com.linan.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class MyRealm implements Realm {

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = (String) token.getPrincipal();
		String password = (String) token.getCredentials();
		
		
		
		if(!"zhangsan".equals(username)){
			throw new UnknownAccountException();
		}
		
		if(!"123".equals(password)){
			throw new UnknownAccountException();
		}
		
		
		return new SimpleAuthenticationInfo(username, password, getName());

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "My-Realm";
	}

	@Override
	public boolean supports(AuthenticationToken arg0) {
		// TODO Auto-generated method stub
		return arg0 instanceof UsernamePasswordToken;
	}

}
