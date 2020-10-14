package com.nishik.spring.upload.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	
	@Column(length=512, nullable=false,unique=true)
	private String email_id;
	
	@Column(length=512, nullable=false)
	private String name;
	
	private byte[] content;
	
	private long size;
	
	private Date upload_date;
	
	public User() {
	}
	
   //generate parameterized constructor for users user_id, name, email_id
	public User(Long user_id, String email_id, String name) {
		super();
		this.user_id = user_id;
		this.email_id = email_id;
		this.name = name;
	}




	//Getters and Setters
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}

	public Date getUpload_date() {
		return upload_date;
	}

	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}
	
	
	
	

}
