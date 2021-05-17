package kodlamaio.hrms.api.controllers;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import org.springframework.web.bind.annotation.*;  // hepsi anlamindadir

import kodlamaio.hrms.business.abstracts.IdentityValidationService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.entity.concretes.Candidate;
import kodlamaio.hrms.entity.concretes.Employer;
import kodlamaio.hrms.entity.concretes.User;
import kodlamaio.hrms.entity.dtos.UserLoginDto;

@RestController
@RequestMapping("api/auth")
public class AuthsController {

	private UserService userService;
	private IdentityValidationService identityValidationService;

	@Autowired
	public AuthsController(UserService userService, IdentityValidationService identityValidationService) {
		super();
		this.userService = userService;
		this.identityValidationService = identityValidationService;
	}

	@PostMapping("login")
	public ResponseEntity<Result> login(@RequestBody() UserLoginDto userLoginDto) {
		
		Base64 base64 = new Base64();
		String password = new String(base64.decode(userLoginDto.getPassword().getBytes()));
		User user = this.userService.findByEmailAddressAndPassword(userLoginDto.getEmail(), password);
		
		if(user == null) {
			return ResponseEntity.status(400).body(new ErrorResult("User not found."));
		}
		return ResponseEntity.status(200).body(new SuccessResult());
	}
	
	@PostMapping(path = "mernis")
	public ResponseEntity<Result> mernis(@RequestBody() UserLoginDto userLoginDto){
		Base64 base64 = new Base64();
		String password = new String(base64.decode(userLoginDto.getPassword().getBytes()));
		User user = this.userService.findByEmailAddressAndPassword(userLoginDto.getEmail(), password);
		Candidate candidate = (Candidate)user;
		Result result = this.identityValidationService.CheckIfRealPerson(candidate.getIdentificationNumber(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate());
		
		if(!result.isSuccess()) {
			return ResponseEntity.status(400).body(result);
		}
		
		return ResponseEntity.status(200).body(new SuccessResult());
	}
	
	@PostMapping(path = "register/employer")
	public User register(@RequestBody(required = true) Employer employer) {
		userService.save(employer);
		return employer;
	}
	
	@PostMapping(path = "register/candidate")
	public User register(@RequestBody(required = true) Candidate candidate) { 
		userService.save(candidate);
		return candidate;
	}
	
}