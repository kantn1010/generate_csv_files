package com.nishik.spring.upload.dao;

import com.nishik.spring.upload.entity.User;

public interface UserDAO {

	public User getAllUser();
	
	public void downloadFile();
	
	public String uploadFile();
}
