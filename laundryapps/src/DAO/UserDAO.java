package DAO;

import java.util.List;

import Model.User;

public interface UserDAO {
	void save(User user);
	public List<User> show();
	public void delete(String id);
	public void update(User user);

}
