package business;

import model.User;

public interface UserService {

	public User findByUserAndPassword(String user, String password);

	public User addUser(User user);

}
