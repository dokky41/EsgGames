package com.esg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public void indexGet() {
		
		log.info("index페이지 실행");
	}
	
	
	@RequestMapping(value="/categories", method=RequestMethod.GET)
	public void categories() {
		
		log.info("categories페이지 실행");
	}
	
	@RequestMapping(value="/community", method=RequestMethod.GET)
	public void community() {
		
		log.info("community페이지 실행");
	}
	
	@RequestMapping(value="/contact", method=RequestMethod.GET)
	public void contact() {
		
		log.info("contact페이지 실행");
	}
	
	@RequestMapping(value="/review", method=RequestMethod.GET)
	public void review() {
		
		log.info("review페이지 실행");
	}
	
	@RequestMapping(value="/maple/community", method=RequestMethod.GET)
	public void m() {
		
		log.info("m페이지 실행");
	}
	
	
	
	
	
}