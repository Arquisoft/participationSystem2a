package business;

import model.User;

public interface UserService {

	public User findByUserAndPassword(String user, String password);

}
