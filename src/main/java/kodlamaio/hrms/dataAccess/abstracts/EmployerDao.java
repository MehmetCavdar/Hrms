package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entity.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	Optional<Employer> findAllByPhonesPhoneNumber(@Param("phoneNumber") String phoneNumber);
}