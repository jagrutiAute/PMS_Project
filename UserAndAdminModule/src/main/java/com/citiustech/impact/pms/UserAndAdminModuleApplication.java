package com.citiustech.impact.pms;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.citiustech.impact.pms.controller.AccountController;
import com.citiustech.impact.pms.model.PatientProfile;
import com.citiustech.impact.pms.model.Title;
import com.citiustech.impact.pms.repository.PatientProfileRepository;
import com.citiustech.impact.pms.repository.UserRepository;

@SpringBootApplication
public class UserAndAdminModuleApplication {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PatientProfileRepository userProfileRepository;
    
    @Autowired
    AccountController acct;

    public static void main(String[] args) {
      SpringApplication.run(UserAndAdminModuleApplication.class, args);
    }

   
}