package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entity.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}
	
	public List<Employer> getAll(){
		return this.employerDao.findAll();
	}
	
	public Employer getById(int id) {
		return this.employerDao.findById(id).orElse(null);
	}
	
	public Employer getByPhoneNumber(String phoneNumber){
		return this.employerDao.findAllByPhonesPhoneNumber(phoneNumber).orElse(null);
	}

	@Override
	public void save(Employer employer) {
		this.employerDao.save(employer);
	}
}
