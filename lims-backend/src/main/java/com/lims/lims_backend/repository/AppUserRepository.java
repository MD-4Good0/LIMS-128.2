package com.lims.lims_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lims.lims_backend.model.AppUser;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
}
