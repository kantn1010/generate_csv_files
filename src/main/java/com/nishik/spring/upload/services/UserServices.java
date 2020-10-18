package com.nishik.spring.upload.services;

import com.nishik.spring.upload.entity.User;

public interface UserServices {
	
	public User getAllUser();
	
	public void downloadFile();
	
	public String uploadFile();

}
