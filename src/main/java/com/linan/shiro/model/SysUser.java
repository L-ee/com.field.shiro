package com.linan.shiro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 用户表
 * @author Lee
 * 2016-01-30
 */
@Table(catalog="shiro",name="sys_user")
@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
public class SysUser implements Serializable {

	/*
	 * 序列号
	 */
	private static final long serialVersionUID = 327076459019194814L;

	/*
	 * id
	 */
	private int id;
	
	/*
	 * 用户名
	 */
	private String username;
	
	/*
	 * 密码
	 */
	private String password;
	
	/*
	 * 盐
	 */
	private String salt;
	
	/*
	 * 角色列表
	 */
	private String roleIds;
	
	/*
	 * 账户是否锁定
	 */
	private boolean locked;

	@Id
	@GeneratedValue
	@Column(name="id",unique=true,nullable=false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="username",insertable=true,updatable=true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="password",insertable=true,updatable=true)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="salt",insertable=true,updatable=true)
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Column(name="role_ids",insertable=true,updatable=true)
	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	@Column(name="locked",insertable=true,updatable=true)
	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	@Override
	public String toString() {
		return "SysUser [id=" + id + ", username=" + username + ", password="
				+ password + ", salt=" + salt + ", roleIds=" + roleIds
				+ ", locked=" + locked + "]";
	}
	
}
