package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.User;
import com.app.repository.UserRepository;
import com.app.service.IUserService;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private IUserService iuservice;
	
	public UserController()
	{
		System.out.println("In class of"+getClass().getName()+" is created");
	}
	@PostMapping("/signup")
	public ResponseEntity<?> addUser(@RequestBody  User u)
	{
		System.out.println("In posting data of User "+u);
		User user=iuservice.signup(u);
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User userdetails)
	{
		System.out.println("In login  of User controller "+userdetails);
	     
		return new ResponseEntity<>(iuservice.login(userdetails), HttpStatus.OK);
		
	}
	
	
}
