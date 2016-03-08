package com.linan.shiro.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.linan.shiro.model.SysResource;
import com.linan.shiro.model.SysRole;
import com.linan.shiro.model.SysUser;


/**
 * 用户登陆认证
 * @author Lee
 * 2016-01-30
 */
public class LoginRealm extends AuthorizingRealm {
	

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public String getName(){
		return "LoginReealm";
	}
	
	public Session getSession(){
		return this.sessionFactory.openSession();
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = (String) token.getPrincipal();
		Query query = getSession().createQuery("FROM SysUser s WHERE s.username = :username").setParameter("username", username);
		SysUser user = (SysUser) query.list().get(0);
		System.out.println(user.toString());
		if(user != null){
			Subject subject = SecurityUtils.getSubject();
			subject.getSession().setAttribute("sysuser", user);
			return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), getName());
		}
		return null;
	}

}
