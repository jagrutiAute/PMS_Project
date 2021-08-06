package com.citiustech.impact.pms.diagnoses;

import org.hibernate.validator.constraints.EAN;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DiagnosesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiagnosesApplication.class, args);
	}

}
