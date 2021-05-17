package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.entity.concretes.JobTitle;

@RestController
@RequestMapping("api/job-titles")
public class JobTitlesController {
	
	private final JobTitleService jobTitleService;

	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	@PostMapping("save")
	public Result save(@RequestBody JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return new SuccessResult("başarılı");
	}
	
	@GetMapping("getall")
	public List<JobTitle> getAll(){
		return jobTitleService.getAll();
	}
	
	@GetMapping("getbyid/{id}")
	public JobTitle getById(@PathVariable int id) {
		return jobTitleService.getById(id);
	}
	
	@GetMapping("getbytitle/{title}") 
	public JobTitle getByTitle(@PathVariable String title) {
		return jobTitleService.getByTitle(title);
	}

}
