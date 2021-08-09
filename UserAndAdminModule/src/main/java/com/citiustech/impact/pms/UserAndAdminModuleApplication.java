package com.citiustech.impact.pms;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
    
    @Bean
	public WebMvcConfigurer corsConfiguration() {
		
		return new WebMvcConfigurer() {
			
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200", "http://www.myapp.com");
			}
		};
	}

   
}