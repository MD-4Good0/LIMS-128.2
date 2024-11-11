package com.backend.lims.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.lims.model.UnverifiedUser;

public interface UnverifiedUserRepository extends JpaRepository<UnverifiedUser, Long>{
	UnverifiedUser findByUsername(String username);
	UnverifiedUser findByEmail(String email);
	UnverifiedUser findByEmailAndOtp(String email, Integer otp);
	UnverifiedUser findByUserId(Long userId);
}
