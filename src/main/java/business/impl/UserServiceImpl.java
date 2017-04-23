package business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import business.UserService;
import model.User;
import repository.UserRepository;


public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository UserRepository;
	
	@Override
	public User findByUserAndPassword(String user, String password) {
		return UserRepository.findByUserAndPassword(user, password);

	}



}
