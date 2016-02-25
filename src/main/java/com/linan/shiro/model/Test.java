package com.linan.shiro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Table(catalog="shiro",name="test")
@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
public class Test implements Serializable {
	
	
	private int id;
	
	private String name;
	
	public Test() {
		super();
	}

	@Id
	@GeneratedValue
	@Column(unique=true,nullable=false)
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

	@Override
	public String toString() {
		return "Test [id=" + id + ", name=" + name + "]";
	}
	
}
