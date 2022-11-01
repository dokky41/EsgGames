package com.esg.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.esg.domain.BoardVO;
import com.esg.persistence.BoardDAO;
import com.esg.service.BoardService;

@Controller
@RequestMapping("/LOLboard/*")

public class LOLboardController {
	
	private static final Logger log = LoggerFactory.getLogger(LOLboardController.class);
	
	@Inject
	BoardService service;
	
	@RequestMapping(value="/categories",method = RequestMethod.GET)
	public void categoriesGet() throws Exception{
		
		log.info("categories.jsp");
		
	}
	@RequestMapping(value="/community",method = RequestMethod.GET)
	public void communityGet() throws Exception{
		
		log.info("community.jsp");
		
	}
	
}
