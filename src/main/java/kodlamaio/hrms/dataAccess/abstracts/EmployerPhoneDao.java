package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entity.concretes.EmployerPhone;

public interface EmployerPhoneDao extends JpaRepository<EmployerPhone, Integer> {
	List<EmployerPhone> findAllByEmployerId(@Param("userId") int userId);
}
