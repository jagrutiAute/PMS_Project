package com.observations.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	
	
	@GetMapping("/observation")
	public String getmsg() {
		return "from observation service";
	}
	
	
}
