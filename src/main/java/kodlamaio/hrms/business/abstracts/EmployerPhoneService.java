package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entity.concretes.EmployerPhone;  // Manuel 


public interface EmployerPhoneService {
	List<EmployerPhone> getAll();
	List<EmployerPhone> getByUserId(int userId);
}