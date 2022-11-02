package com.esg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.esg.controller.mapleboardController;



@Controller
@RequestMapping("/maple/*")
public class mapleboardController {
	
	private static final Logger log = LoggerFactory.getLogger(mapleboardController.class);
	
	@RequestMapping(value="/maple/community",method=RequestMethod.GET)
	public void mapleGet() throws Exception {
		
		log.info("maple페이지 실행");
		
		
	}
	

}
