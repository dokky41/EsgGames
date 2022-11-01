package com.esg.controller;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.esg.service.LoaService;

@Controller
@RequestMapping("/ydTrBoard/*")
public class YdTradeController {

	
	private static final Logger log = LoggerFactory.getLogger(YdTradeController.class);
	
	@Inject
	private LoaService service;
	
	@RequestMapping(value="/trLostArk",method=RequestMethod.GET)
	public void gettrLostArk(Model model) {
		
		log.info("LostArk 거래페이지로 이동");

		//로아 최신뉴스
		JSONArray LoaNews = service.getLoaNews();
		
		model.addAttribute("LoaNews", LoaNews);
		
		log.info(LoaNews+"");
	
	}
	
	
}
