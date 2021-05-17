package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;

public interface AuthService {
	Result login(String emailAdress, String password);
}