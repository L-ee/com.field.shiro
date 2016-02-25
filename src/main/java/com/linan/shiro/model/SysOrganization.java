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
 * ��֯������
 * @author Lee
 * 2016-01-30
 */
@Table(catalog="shiro",name="sys_organization")
@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
public class SysOrganization implements Serializable {

	/*
	 * ���к� 
	 */
	private static final long serialVersionUID = 3482862626657320687L;
	
	
	/*
	 * id
	 */
	private int id;
	
	/*
	 * ��֯������
	 */
	private String name;
	
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
	 * �Ƿ����
	 */
	private boolean available;

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

	@Column(name="available",insertable=true,updatable=true)
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "SysOrganization [id=" + id + ", name=" + name + ", priority="
				+ priority + ", parentId=" + parentId + ", parentIds="
				+ parentIds + ", available=" + available + "]";
	}
	
}
