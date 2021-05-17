package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entity.concretes.Candidate;

public interface CandidateService {
	void save(Candidate candidate);
	List<Candidate> getAll();
	Candidate getById(int id);
	Candidate getByFirstName(String string);
	Candidate getByEmailAddress(String string);
}