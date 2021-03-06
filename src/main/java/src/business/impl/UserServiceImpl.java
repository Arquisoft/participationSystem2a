package src.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.business.UserService;
import src.model.User;
import src.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findByUserAndPassword(String usuario, String contraseña) {
		return userRepository.findByUserAndPassword(usuario, contraseña);
	}
}