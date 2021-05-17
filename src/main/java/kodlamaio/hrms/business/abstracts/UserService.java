package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entity.concretes.User;

public interface UserService {
	void save(User user);
	User findByEmailAddressAndPassword(String email, String password);
}