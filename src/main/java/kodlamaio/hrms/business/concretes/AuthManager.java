package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.IdentityValidationService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entity.concretes.Candidate;

@Service
public class AuthManager implements AuthService {
	
	private IdentityValidationService identityValidationService;
	private CandidateService candidateService;

	@Autowired
	public AuthManager(IdentityValidationService identityValidationService, CandidateService candidateService) {
		super();
		this.identityValidationService = identityValidationService;
		this.candidateService = candidateService;
	}

	@Override
	public Result login(String emailAdress, String password) {
		Candidate candidate = this.candidateService.getByEmailAddress(emailAdress);
		return this.identityValidationService.CheckIfRealPerson(candidate.getIdentificationNumber(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate());
	}

}