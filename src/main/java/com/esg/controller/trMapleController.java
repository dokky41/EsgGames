package com.esg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/trBoard/*")
public class trMapleController {

	
	private static final Logger log = LoggerFactory.getLogger(trMapleController.class);
	
	@RequestMapping(value="/maple",method=RequestMethod.GET)
	public void getTrmaple() {
		
	}
	
	
}
