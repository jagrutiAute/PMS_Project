package com.citiustech.impact.pms;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.citiustech.impact.pms.controller.AccountController;
import com.citiustech.impact.pms.model.PatientProfile;
import com.citiustech.impact.pms.model.Title;
import com.citiustech.impact.pms.model.User;
import com.citiustech.impact.pms.repository.PatientProfileRepository;
import com.citiustech.impact.pms.repository.UserRepository;

@SpringBootApplication
public class UserAndAdminModuleApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PatientProfileRepository userProfileRepository;
    
    @Autowired
    AccountController acct;

    public static void main(String[] args) {
      SpringApplication.run(UserAndAdminModuleApplication.class, args);
    }

    public void run(String... args) throws Exception {
    	
    	//PatientProfile p=new PatientProfile();
    	//String message=acct.patienRegister(p);
    	//System.out.println(message);
        // Clean up database tables
		/*
		 * userProfileRepository.deleteAllInBatch(); userRepository.deleteAllInBatch();
		 * 
		 * //=========================================
		 * 
		 * // Create a User instance User user = new User("shivraj@gmail.com",
		 * 234343443, "Shivraj@123",1);
		 * 
		 * Calendar dateOfBirth = Calendar.getInstance(); dateOfBirth.set(1992, 7, 21);
		 * 
		 * // Create a UserProfile instance PatientProfile patientProfile = new
		 * PatientProfile(Title.MR, "Shivraj", "Pawar", dateOfBirth,1,1);
		 * 
		 * 
		 * // Set child reference(userProfile) in parent entity(user)
		 * user.setUserProfile(patientProfile);
		 * 
		 * // Set parent reference(user) in child entity(userProfile)
		 * patientProfile.setUser(user);
		 * 
		 * // Save Parent Reference (which will save the child as well)
		 * userRepository.save(user);
		 */

        //=========================================
    }
}