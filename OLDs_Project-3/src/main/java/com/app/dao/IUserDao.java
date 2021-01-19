package com.app.dao;

import com.app.dto.ResponseDTO;
import com.app.pojos.User;

public interface IUserDao {


	public ResponseDTO login(User userDetails);
}
