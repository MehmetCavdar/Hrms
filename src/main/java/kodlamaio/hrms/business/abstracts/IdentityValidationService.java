package kodlamaio.hrms.business.abstracts;

import java.util.Date;

import kodlamaio.hrms.core.utilities.result.Result;

public interface IdentityValidationService {
	Result CheckIfRealPerson(Long identityNumber, String firstName, String lastName, int birthYear);
	Result CheckIfRealPerson(String identityNumber, String firstName, String lastName, Date birthDate);
	Result CheckIfRealPerson(Long identityNumber, String firstName, String lastName, Date birthDate);
}