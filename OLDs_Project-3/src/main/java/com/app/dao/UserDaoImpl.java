package com.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.dto.ResponseDTO;
import com.app.pojos.User;

@Repository
public class UserDaoImpl implements IUserDao{

	@PersistenceContext
	EntityManager manager;


	@Override
	public ResponseDTO login(User userDetails) {
		// TODO Auto-generated method stub
		String jpql = "select u from User u where u.email=:email And u.password=:password";

		User details = manager.createQuery(jpql, User.class).setParameter("email", userDetails.getEmail())
				.setParameter("password", userDetails.getPassword()).getSingleResult();
		if (details == null)
		 	throw new NoResultException();
		return new ResponseDTO("sucess", "login successFull", details);
	}

	
}
