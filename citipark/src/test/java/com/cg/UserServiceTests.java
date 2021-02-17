package com.cg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.citipark.beans.User;
import com.cg.citipark.exception.DuplicateUserException;
import com.cg.citipark.repository.UserRepository;
import com.cg.citipark.service.UserService;
import com.cg.citipark.service.UserServiceImpl;
import static org.junit.Assert.assertEquals;

class UserServiceTests {
	
	UserService userService;
	
	@Mock
	UserRepository userRepository; 

	@SuppressWarnings("deprecation")
	@Before
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		userService = new UserServiceImpl(userRepository);
	}
	
	/*@Test(expected = com.cg.citipark.exception.DuplicateUserException.class)
	public void testDuplicateUser() throws DuplicateUserException
	{
		User user = new User();
		userService.addUser(user);
	}*/

}
