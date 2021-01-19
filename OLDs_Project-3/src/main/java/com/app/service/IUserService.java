package com.app.service;

import com.app.dto.ResponseDTO;
import com.app.pojos.User;

public interface IUserService {
	
	public User signup(User u);
	
	public ResponseDTO login(User u);

}
