package com.lims.lims_backend.service;

import com.lims.lims_backend.model.AppUser;
import com.lims.lims_backend.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImplementation implements AppUserService{

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public AppUser saveAppUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }
}
