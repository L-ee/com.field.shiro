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
 * 用户登录验证
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
		Set<String> role = new HashSet<String>();
		SysUser user = (SysUser) SecurityUtils.getSubject().getSession().getAttribute("sysuser");
		String roleIds = user.getRoleIds();
		Query query = getSession().createQuery("FROM SysRole s WHERE s.id = :id").setParameter("id", roleIds);
		SysRole roles = (SysRole) query.list().get(0);
		role.add(roles.getRole());
		info.setRoles(role);
		
		String resourceIds = roles.getResourceIds();
		Set<String> resource = new HashSet<String>();
		String[] split = resourceIds.split(",");
		for (String string : split) {
			Query q = getSession().createQuery("FROM SysResource s WHERE s.id = :id").setParameter("id", string);
			SysResource r = (SysResource) q.list().get(0);
			resource.add(r.getPermission());
		}
		info.setStringPermissions(resource);
		
		System.out.println("=========================doGetAuthorizationInfo====================================");
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = (String) token.getPrincipal();

		Query query = getSession().createQuery("FROM SysUser s WHERE s.username = :username").setParameter("username", username);
		SysUser user = (SysUser) query.list().get(0);
		if(user != null){
			Subject subject = SecurityUtils.getSubject();
			subject.getSession().setAttribute("sysuser", user);
			return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), getName());
		}
		return null;
	}

}
