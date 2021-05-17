package kodlamaio.hrms.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.entity.concretes.Candidate;


@RestController
@RequestMapping(path = "/api/candidates/")
public class CandidatesController {

	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	};
	
	@PostMapping(path = "save")
	public Result save(@RequestBody Candidate candidate) {
		this.candidateService.save(candidate);
		
		return new SuccessResult("mesaj");
	};

	@GetMapping(path = "getall")
	public List<Candidate> getAll(){
		return this.candidateService.getAll(); 
	};
	
	@GetMapping(path = "getbyid/{id}")
	public Candidate getById(@PathVariable int id) {
		return this.candidateService.getById(id);
	};
	
	@GetMapping(path = "getbyfirstname/{firstName}")
	public Candidate getByFirstname(@PathVariable String firstName) {
		return this.candidateService.getByFirstName(firstName);
	};
	
	@GetMapping(path = "getbyemailaddress/{emailAddress}")
	public Candidate getByEmailAddress(@PathVariable String emailAddress) {
		return this.candidateService.getByEmailAddress(emailAddress);
	};
	
}