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
 * 角色表
 * @author Lee
 * 2016-01-30
 */
@Table(catalog="shiro",name="sys_role")
@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
public class SysRole implements Serializable {

	/*
	 * 序列号 
	 */
	private static final long serialVersionUID = 866231453632746366L;

	/*
	 * id
	 */
	private int id;
	
	/*
	 * 角色名称
	 */
	private String role;
	
	/*
	 * 角色描述
	 */
	private String description;
	
	/*
	 * 授权的资源
	 */
	private String resourceIds;
	
	/*
	 * 是否可用
	 */
	private boolean available;

	public SysRole() {
		super();
	}

	@Id
	@GeneratedValue
	@Column(name="id",unique=true,nullable=false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="role",insertable=true,updatable=true)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name="description",insertable=true,updatable=true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="resource_ids",insertable=true,updatable=true)
	public String getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}

	@Column(name="available",insertable=true,updatable=true)
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "SysRole [id=" + id + ", role=" + role + ", description="
				+ description + ", resourceIds=" + resourceIds + ", available="
				+ available + "]";
	}
	
}
