package com.esg.controller;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.esg.service.MainService;

@Controller
public class MainController {

	@Inject
	MainService service;
	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public void indexGet(Model model) {
		
		log.info("index페이지 실행");
		
		//게임메카 게임 순위
		JSONArray gameMeca = service.getgameMeca();
				
		model.addAttribute("gameMeca", gameMeca);
				
		log.info(gameMeca+"");
		//게임메카 게임 순위
		
		
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