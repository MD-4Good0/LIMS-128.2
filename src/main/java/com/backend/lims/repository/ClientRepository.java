package com.backend.lims.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.lims.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	Client findByUserId(Long userId);
	List<Client> findAll(); 
}
