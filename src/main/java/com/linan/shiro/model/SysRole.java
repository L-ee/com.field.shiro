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
 * ��ɫ��
 * @author Lee
 * 2016-01-30
 */
@Table(catalog="shiro",name="sys_role")
@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
public class SysRole implements Serializable {

	/*
	 * ���к� 
	 */
	private static final long serialVersionUID = 866231453632746366L;

	/*
	 * id
	 */
	private int id;
	
	/*
	 * ��ɫ����
	 */
	private String role;
	
	/*
	 * ��ɫ����
	 */
	private String description;
	
	/*
	 * ��Ȩ����Դ
	 */
	private String resourceIds;
	
	/*
	 * �Ƿ����
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
