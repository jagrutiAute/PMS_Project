package com.citiustech.impact.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PatientDetails {

	public static void main(String[] args) {
		// changes are done
		SpringApplication.run(PatientDetails.class, args);

	}

}
