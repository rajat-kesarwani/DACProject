package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUserDao;
import com.app.dto.ResponseDTO;
import com.app.pojos.User;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserService implements IUserService{

	@Autowired
	private IUserDao iuserdao;
	
	@Autowired
	private UserRepository userrepo; 
	@Override
	public User signup(User u) {
		// TODO Auto-generated method stub
		User user=userrepo.save(u);
		return u;
	}

	@Override
	public ResponseDTO login(User u) {
		// TODO Auto-generated method stub
		
	     return	iuserdao.login(u);
	
	}

}
