package com.backend.lims.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.lims.model.UnverifiedClient;

public interface UnverifiedClientRepository extends JpaRepository<UnverifiedClient, Long> {
	UnverifiedClient findByUserId(Long userId);
	List<UnverifiedClient> findAll(); 
}
