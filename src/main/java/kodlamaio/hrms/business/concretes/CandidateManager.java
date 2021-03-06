package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entity.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {
	
	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public void save(Candidate candidate) {
		this.candidateDao.save(candidate);
	}	
	
	@Override
	public List<Candidate> getAll() {
		return this.candidateDao.findAll(); 
	}
	
	@Override
	public Candidate getById(int id) {
		return this.candidateDao.findById(id).orElse(null);
	}

	@Override
	public Candidate getByFirstName(String string) {
		return this.candidateDao.findFirstByFirstNameIgnoreCase(string).orElse(null);
	}

	@Override
	public Candidate getByEmailAddress(String string) {
		return this.candidateDao.findByEmailAddressIgnoreCase(string).orElse(null);
	}

}
