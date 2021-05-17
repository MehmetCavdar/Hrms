package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerPhoneService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerPhoneDao;
import kodlamaio.hrms.entity.concretes.EmployerPhone;

@Service
public class EmployerPhoneManager implements EmployerPhoneService{

	private EmployerPhoneDao employerPhoneDao;
	
	public EmployerPhoneManager(EmployerPhoneDao employerPhoneDao) {
		super();
		this.employerPhoneDao = employerPhoneDao;
	}


	@Override
	public List<EmployerPhone> getAll() {
		return this.employerPhoneDao.findAll();
	}


	@Override
	public List<EmployerPhone> getByUserId(int userId) {
		return this.employerPhoneDao.findAllByEmployerId(userId);
	}
	
}