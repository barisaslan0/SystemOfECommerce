package systemOfECommerce.business.concretes;

import java.util.List;

import systemOfECommerce.business.abstracts.UserService;
import systemOfECommerce.dataAccess.abstracts.UserDao;
import systemOfECommerce.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;

	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		userDao.add(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);

	}

	@Override
	public void delete(User user) {
		userDao.delete(user);

	}
	
	@Override
	public User getUser(int id) {
		return userDao.getUser(id);
	}
	
	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}
}
