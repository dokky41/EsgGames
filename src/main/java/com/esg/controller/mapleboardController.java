package com.esg.controller;


import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.esg.controller.mapleboardController;
import com.esg.domain.Criteria;
import com.esg.domain.PageMaker;

import com.esg.domain.mapleboardVO;
import com.esg.service.mapleboardService;
import com.esg.domain.mapleFileVO;





@Controller
@RequestMapping("/maple/*")
public class mapleboardController {
	
	private static final Logger log = LoggerFactory.getLogger(mapleboardController.class);
	
	@Inject
	mapleboardService service;
	
	@RequestMapping(value="/maple/mapleboardlist",method=RequestMethod.GET)
	public void mapleGet(Model model,Criteria cri) throws Exception {
		
		log.info("maple페이지 실행");
		List<mapleboardVO> maplelist = service.mapleboardlist(cri);
		log.info(""+service.mapleboardlist(cri));
		model.addAttribute("maplelist", maplelist);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		pageMaker.setTotalCount(service.totalCnt());
		
		model.addAttribute("pm",pageMaker);
		
	}
	
	
	@RequestMapping(value="/maple/mapleboardwrite",method=RequestMethod.GET)
	public void maple1Get() throws Exception{
		
		log.info("글쓰기페이지 실행");
	}
	
	@RequestMapping(value="/maple/mapleboardwrite", method=RequestMethod.POST)
	public ModelAndView maple2Post(mapleboardVO vo,mapleFileVO vo1,MultipartFile[] file) throws Exception {
		log.info(vo+"");
		log.info(file[0].getOriginalFilename()+"");
		vo1.setBOARD_IDX(service.getBoardNum());
		ModelAndView mav = new ModelAndView("redirect:/maple/mapleboardlist");
		service.mapleboardwrite(vo);
		
		if(!(file[0].getOriginalFilename()).equals("")) {
			service.insertFile(vo1,file);
		}
		return mav;
	
		
		
	
	
		
	}
	
	
	
	@RequestMapping(value="/maple/mapleboardlist", method=RequestMethod.POST)
	public void postmaple(Model model,HttpSession session,
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
		
		service.updatemapleBoardCount(num);
		mapleboardVO mapleread = service.getmapleContent(num);
		model.addAttribute("mapleboard", mapleread);
		
		List<Map<String,Object>> fileList=service.selectFileList(num);
		model.addAttribute("file", fileList);
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
