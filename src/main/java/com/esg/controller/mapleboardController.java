package com.esg.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.esg.controller.mapleboardController;
import com.esg.domain.Criteria;
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
		log.info(""+service.mapleboardlist());
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
	
	@RequestMapping(value="/maple/mapleboardlist", method=RequestMethod.POST)
	public void posttrLostArk(Model model,HttpSession session,
			Criteria cri,@RequestParam("searchName") String searchName) throws Exception {
		
		log.info("maple페이지 검색" );
		
		List<mapleboardVO> mapleboardList =  service.mapleSearchList(cri);
		model.addAttribute("maplelist", mapleboardList );
	
	}
	
	//value값에는 form태그의 action경로를 적어준다. method는 form태그와 똑같이 해준다. 
	//model객체는 jsp페이지로 data를 전달해준다. @RequestParam은 jsp에서 값을 받아 사용할 수 있게 해준다. 
	//HttpSession은 페이지내의 session정보를 저장해준다. (ex.login)
	@RequestMapping(value="/mapleread", method=RequestMethod.GET)
	public void getmapleContent(Model model,HttpSession session,
			@RequestParam("num") int num) {
		
		log.info("mapleread페이지로 이동 ");
		
		mapleboardVO mapleread = service.getmapleContent(num);
		model.addAttribute("mapleboard", mapleread);
	}
	
	@RequestMapping(value="/maplemodify", method=RequestMethod.GET)
	public void getmaplemodify(Model model,HttpSession session,
			@RequestParam("num") int num) {
		
		log.info("maplemodify페이지로 이동 ");
		
		mapleboardVO mapleread = service.getmapleContent(num);
		model.addAttribute("mapleboard", mapleread);
	}
	
	
	@RequestMapping(value="/maple/maplemodify",method=RequestMethod.POST)
	public String postmaplemodify(Model model,HttpSession session,
			@RequestParam("num") int num,mapleboardVO vo) {
		
		log.info("maplemodify 글쓰기 수정하기 ");
		
		
		service.getmaplemodify(vo);
		
		return "redirect:/maple/mapleboardlist";
	
	}
	
	@RequestMapping(value="/mapledelete",method=RequestMethod.GET)
	public String postmapledelete(@RequestParam("num") int num) {
		
		log.info("maplemodify 글쓰기 삭제하기");
		
		
		service.getmapledelete(num);
		
		return "redirect:/maple/mapleboardlist";
	}
	

}
