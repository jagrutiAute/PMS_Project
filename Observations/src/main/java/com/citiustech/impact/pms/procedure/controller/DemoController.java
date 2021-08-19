package com.citiustech.impact.pms.procedure.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	static Logger log = Logger.getLogger(DemoController.class.getName());

	
	@GetMapping("/observation")
	public String getmsg() {
		
		log.debug("inside getmsg() method of DemoController class");
		
		return "from observation service";
	}
	
	
}
