package systemOfECommerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import systemOfECommerce.dataAccess.abstracts.UserDao;
import systemOfECommerce.entities.concretes.User;

public class InMemoryUserDao implements UserDao {

	List<User> users = new ArrayList<User>();

	@Override
	public void add(User user) {
		users.add(user);
		System.out.println("Sisteme kayýt olundu: " + user.getFirstName() + " " + user.getLastName());
	}

	@Override
	public void update(User user) {
		User updatedUser = getUser(user.getId());
		updatedUser.setFirstName(user.getFirstName());
		updatedUser.setLastName(user.getLastName());
		updatedUser.setPassword(user.getPassword());
		System.out.println("Bilgileriniz güncellendi: " + user.getFirstName() + " " + user.getLastName());
	}

	@Override
	public void delete(User user) {
		users.remove(user);
		System.out.println("Hesabýnýz silindi: " + user.getFirstName() + " " + user.getLastName());
	}

	@Override
	public User getUser(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		for (User user : users) {
			if (user.getEmail() == email) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		return users;
	}
}
