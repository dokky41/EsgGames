package com.esg.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.esg.controller.mapleboardController;
import com.esg.domain.mapleboardVO;
import com.esg.service.mapleboardService;




@Controller
@RequestMapping("/maple/*")
public class mapleboardController {
	
	private static final Logger log = LoggerFactory.getLogger(mapleboardController.class);
	
	@Inject
	mapleboardService service;
	
	@RequestMapping(value="/maple/mapleboardlist",method=RequestMethod.GET)
	public void mapleGet(Model model) throws Exception {
		
		log.info("maple페이지 실행");
		List<mapleboardVO> maplelist = service.mapleboardlist();
		model.addAttribute("maplelist", maplelist);
		
		
	}
	
	
	@RequestMapping(value="/maple/mapleboardwrite",method=RequestMethod.GET)
	public void maple1Get() throws Exception{
		
		log.info("글쓰기페이지 실행");
	}
	
	@RequestMapping(value="/maple/mapleboardwrite", method=RequestMethod.POST)
	public String maple2Post(mapleboardVO vo) throws Exception {
		//log.info(vo+"");
		service.mapleboardwrite(vo);
		
		return "redirect:/maple/mapleboardlist";
	}
	
	
	
	

}
