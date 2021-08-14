package com.diagnoses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
@RestController
public class UserInfoController {

	
		
	
	
	@GetMapping("/some/info")
	@HystrixCommand(fallbackMethod="getUserInfoFromObservationFallaback", commandProperties= {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="2000"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="8"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="50"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="10000")
        })
	public String getUserInfoFromObservation() {
		RestTemplate restTemplate=new RestTemplate();
		return  restTemplate.getForObject("http://imcybcp270-msl1.mumbai1.corp.citiustech.com:8096/observation", String.class);
	}
	
	public String getUserInfoFromObservationFallaback() {
		return "closed";
	}
	
}
