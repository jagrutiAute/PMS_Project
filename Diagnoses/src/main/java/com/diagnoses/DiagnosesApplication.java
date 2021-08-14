package com.diagnoses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient

  @EnableCircuitBreaker
  
  @EnableHystrixDashboard
 
public class DiagnosesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiagnosesApplication.class, args);
	}

}

