package com.lims.lims_backend.controller;

import com.lims.lims_backend.model.AppUser;
import com.lims.lims_backend.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appuser")
public class AppUserController {
    @Autowired
    private AppUserService appUserService;

    @PostMapping("/add")
    public String add(@RequestBody AppUser appUser){
        appUserService.saveAppUser(appUser);
        return "User is successfully created";
    }

}
