package com.cg.citipark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.citipark.beans.User;

import com.cg.citipark.beans.Login;
import com.cg.citipark.service.MapValidationErrorService;
import com.cg.citipark.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("/adduser")
	public ResponseEntity<?> addUser(@RequestBody User user,BindingResult result)
	{
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null) 
			return errorMap;
		User registerUser = userService.addUser(user);
		return new ResponseEntity<User>(registerUser, HttpStatus.OK);
	}
	
	@GetMapping("/user/{email}")
	public  ResponseEntity<?> getUserByEmail(@PathVariable String email)
	{
		
		return new ResponseEntity<User>(userService.getUserByEmail(email), HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable Long userId, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null) 
			return errorMap;
		User user = userService.readUserById(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable long id)
	{
		return new ResponseEntity<User>(userService.deleteUserById(id),HttpStatus.OK);
	}
	
	@PutMapping("/user/update")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@GetMapping("/user/login")
	public boolean Login(@PathVariable String loginId, @PathVariable String password) {
		boolean b = userService.login(loginId, password);
		if(b)
			System.out.println("Login successful");
		else
			System.out.println("Invalid Login Credentials");
		return false;
		
	}
}
