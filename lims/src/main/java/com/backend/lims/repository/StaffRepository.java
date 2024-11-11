package com.backend.lims.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.lims.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {
	Staff findByUserId(Long userId);
	List<Staff> findAll(); 
}
