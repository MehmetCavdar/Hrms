package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entity.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {

	Optional<JobTitle> findByTitle(@Param("title") String title);
	
}