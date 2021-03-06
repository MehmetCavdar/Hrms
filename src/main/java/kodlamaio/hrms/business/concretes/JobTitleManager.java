package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entity.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;
	
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public void save(JobTitle jobTitle) {
		this.jobTitleDao.save(jobTitle);
	}
	
	@Override
	public List<JobTitle> getAll() {
		return this.jobTitleDao.findAll();
	}


	@Override
	public JobTitle getById(int id) {
		return this.jobTitleDao.findById(id).orElse(null);
	}
	
	@Override
	public JobTitle getByTitle(String title) {
		return this.jobTitleDao.findByTitle(title).orElse(null);
	}


}