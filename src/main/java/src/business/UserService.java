package src.business;

import src.model.User;

public interface UserService {
	
	public User addUser(User user);
	public User findByUserAndPassword(String usuario, String contraseña);
	
}