package com.cg.citipark.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.citipark.beans.Login;
import com.cg.citipark.beans.User;
import com.cg.citipark.exception.DuplicateUserException;
import com.cg.citipark.exception.InvalidLoginCredentialsException;
import com.cg.citipark.exception.NoSuchUserFoundException;
import com.cg.citipark.repository.LoginRepository;
import com.cg.citipark.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
    UserRepository userRepository;
	@Autowired
    LoginRepository loginRepository;
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public UserServiceImpl(LoginRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;
	}

	@Override
	public User addUser(User user) {
		User registerUser = userRepository.findByEmail(user.getEmail());
		if(registerUser==null)
		{
			return userRepository.save(user);
		}
		else
			throw new DuplicateUserException("User with email : " + user.getEmail()
					+ " already exists");
		
	}
	@Override
	public User getUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
	    }
	
	
	@Override
	public User readUserById(Long userId) {
		User user = userRepository.findById(userId).get();
		if (user == null) 
			throw new NoSuchUserFoundException("User with id: "+userId+" does not exists");
		return user;
	}
	@Override
	public User deleteUserById(Long userId)
    {
    	User user= userRepository.findById(userId).get();
		if (user== null) {
			throw new NoSuchUserFoundException("Can not delete user with id : " + userId
					+ ". This user does not exist");
		}
		userRepository.deleteById(userId);
		return user;
    }
	
	
	@Transactional
	@Override
	public User updateUser(User user) {
		User updateUser = userRepository.findById(user.getUserId()).get();
		if(updateUser!= null)
			return userRepository.save(user);
		return null;
	}
		
	@Override
	public boolean login(String loginId,String password)
	{
		Login login = loginRepository.findById(loginId).get();
				if(login==null)
					throw new InvalidLoginCredentialsException("Invalid User Login Credentials");
				if(login.getPassword().equals(password))
					return true;
				else return false;
	}
}

