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
 * ��Դ
 * @author Lee
 * 2016-01-30
 */
@Table(catalog="shiro",name="sys_resource")
@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
public class SysResource implements Serializable {

	/*
	 * ���к� 
	 */
	private static final long serialVersionUID = 4700448324587737147L;

	/*
	 * id
	 */
	private int id;
	
	/*
	 * ��Դ����
	 */
	private String name;
	
	/*
	 * ��Դ����
	 */
	private String type;
	
	/*
	 * ��ʾ˳��
	 */
	private int priority;
	
	/*
	 * �����
	 */
	private int parentId;
	
	/*
	 * ������б�
	 */
	private String parentIds;
	
	/*
	 * Ȩ���ַ���
	 */
	private String permission;
	
	/*
	 * �Ƿ����
	 */
	private boolean available;

	public SysResource() {
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

	@Column(name="name",insertable=true,updatable=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="type",insertable=true,updatable=true)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name="priority",insertable=true,updatable=true)
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Column(name="parent_id",insertable=true,updatable=true)
	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	@Column(name="parent_ids",insertable=true,updatable=true)
	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	@Column(name="permission",insertable=true,updatable=true)
	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
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
		return "SysResource [id=" + id + ", name=" + name + ", type=" + type
				+ ", priority=" + priority + ", parentId=" + parentId
				+ ", parentIds=" + parentIds + ", permission=" + permission
				+ ", available=" + available + "]";
	}
	
}
