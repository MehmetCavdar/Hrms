package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entity.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	
	Optional<Candidate> findFirstByFirstNameIgnoreCase(@Param("firstName") String firstName);
	Optional<Candidate> findByEmailAddressIgnoreCase(@Param("emailAddress") String emailAddress);
}