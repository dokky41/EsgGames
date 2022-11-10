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
		
		log.info("index�럹�씠吏� �떎�뻾");
	}
	
	
	@RequestMapping(value="/categories", method=RequestMethod.GET)
	public void categories() {
		
		log.info("categories�럹�씠吏� �떎�뻾");
	}
	
	@RequestMapping(value="/community", method=RequestMethod.GET)
	public void community() {
		
		log.info("community�럹�씠吏� �떎�뻾");
	}
	
	@RequestMapping(value="/contact", method=RequestMethod.GET)
	public void contact() {
		
		log.info("contact�럹�씠吏� �떎�뻾");
	}
	
	@RequestMapping(value="/review", method=RequestMethod.GET)
	public void review() {
		
		log.info("review�럹�씠吏� �떎�뻾");
	}
	
	@RequestMapping(value="/singleblog", method=RequestMethod.GET)
	public void singleblog() {
		
		log.info("singleblog�럹�씠吏� �떎�뻾");
	}
	@RequestMapping(value="/trBoard/trmaple", method=RequestMethod.GET)
	public void trmaple() {
		
		log.info("community");
	}
	
	
	
}
