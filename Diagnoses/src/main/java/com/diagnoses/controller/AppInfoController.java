package com.diagnoses.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class AppInfoController {

	@Value("${app.version}")
	private String appVersion;

	@Value("${app.name}")
	private String appName;

	@Value("${app.author.email}")
	private String appAuthorEmail;

	@GetMapping("/api/v1/app-info")
	public String getAppDetails() {
		return "   " + appName + "  " + appAuthorEmail;
	}
	
<<<<<<< HEAD
	@GetMapping("/some/gajanan/123")
=======
	@GetMapping("/some/shivraj/123")
>>>>>>> branch 'Login' of git@github.com:jagrutiAute/PMS_Project.git
	public String get() {
		return "hello word12";
	}

}
