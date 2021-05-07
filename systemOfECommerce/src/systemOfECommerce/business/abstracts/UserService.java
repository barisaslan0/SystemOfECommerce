package systemOfECommerce.business.abstracts;

import java.util.List;

import systemOfECommerce.entities.concretes.User;

public interface UserService {
	void add(User user);

	void update(User user);

	void delete(User user);

	User getUser(int id);

	User getUserByEmail(String email);

	List<User> getAll();

}
