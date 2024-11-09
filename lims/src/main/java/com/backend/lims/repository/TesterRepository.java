package com.backend.lims.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.lims.model.Tester;

public interface TesterRepository extends JpaRepository<Tester, Long> {
	Tester findByUserId(Long userId);
	List<Tester> findAll(); 
}
