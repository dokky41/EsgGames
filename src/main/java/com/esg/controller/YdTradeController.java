package com.esg.controller;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.esg.domain.Criteria;
import com.esg.domain.PageMaker;
import com.esg.domain.trLoaVO;
import com.esg.service.TrLoaService;

@Controller
@RequestMapping("/ydTrBoard/*")
public class YdTradeController {

	
	private static final Logger log = LoggerFactory.getLogger(YdTradeController.class);
	
	@Inject
	private TrLoaService service;
	
	
	@RequestMapping(value="/trLoaContent",method = RequestMethod.GET)
	public void gettrLoaContent(Model model,HttpSession session
			,@RequestParam("num") int num) {
		
		log.info("LostContent 거래상세페이지 이동");

		
		//로아 최신뉴스 크롤링
		JSONArray LoaNews = service.getLoaNews();
		
		model.addAttribute("LoaNews", LoaNews);
		
		session.setAttribute("userid", "admin");
		session.setAttribute("userpw", "1234");
		
//		log.info(LoaNews+"");
		//로아 최신뉴스 크롤링
		
		//해당글내용 불러오기
		session.setAttribute("trLoa", service.getTrLoaContent(num));
		//해당글내용 불러오기
		
		
	}
	
	
	@RequestMapping(value="/trLostArk",method=RequestMethod.GET)
	public void gettrLostArk(Model model,HttpSession session,
			Criteria cri) throws Exception {
		
		log.info("LostArk 거래페이지 이동");

		
		//로아 최신뉴스 크롤링
		JSONArray LoaNews = service.getLoaNews();
		
		model.addAttribute("LoaNews", LoaNews);
		
		session.setAttribute("userid", "admin");
		session.setAttribute("userpw", "1234");
		
//		log.info(LoaNews+"");
		//로아 최신뉴스 크롤링
		
		//로아 거래글 목록 불러오기
		List<trLoaVO> trLoaList =  service.trLoaBoardList(cri);
		//로아 거래글 목록 불러오기
	
		log.info("어어"+trLoaList+"");
		
		
		
		model.addAttribute("listSize", service.totalCnt());
		
		//로아글목록 저장
		model.addAttribute("trLoaList",trLoaList);
		//로아글목록 저장
		
		
		
		//하단 페이징처리 정보 전달
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		pageMaker.setTotalCount(service.totalCnt());
		
		model.addAttribute("pm",pageMaker);
		
				
				
	}
	@RequestMapping(value="/trLostArk",method=RequestMethod.POST)
	public void posttrLostArk(Model model,HttpSession session,
			Criteria cri,@RequestParam("searchName") String searchName) throws Exception {
		
		log.info("LostArk 거래페이지 검색");
		
		
		//로아 최신뉴스 크롤링
		JSONArray LoaNews = service.getLoaNews();
		
		model.addAttribute("LoaNews", LoaNews);
		
		session.setAttribute("userid", "admin");
		session.setAttribute("userpw", "1234");
		
//		log.info(LoaNews+"");
		//로아 최신뉴스 크롤링
		
		//로아 거래글 목록 불러오기
		List<trLoaVO> trLoaList =  service.trLoaSearchList(cri);
		//로아 거래글 목록 불러오기
		
		
		log.info("ok:"+trLoaList+"");
		//거래글수
		model.addAttribute("listSize", service.totalCnt2(searchName));
		//거래글수		
	
		//로아글목록 저장
		model.addAttribute("trLoaList",trLoaList);
		//로아글목록 저장
		
		//하단 페이징처리 정보 전달
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		pageMaker.setTotalCount(service.totalCnt2(searchName));
		
		model.addAttribute("pm",pageMaker);
		
		
	}
	
	@RequestMapping(value="/trLostWrite",method=RequestMethod.GET)
	public void gettrLostWrite(Model model,HttpSession session) {
		
		log.info("LostArk 거래작성페이지로 이동");
		
		//로아 최신뉴스 크롤링
		JSONArray LoaNews = service.getLoaNews();
		
		model.addAttribute("LoaNews", LoaNews);
		
		log.info(LoaNews+"");
		//로아 최신뉴스 크롤링
		
	}
	
	
	@RequestMapping(value="/trLoaWrite",method=RequestMethod.POST)
	public String gettrLostWrite(ArrayList<MultipartFile> files,
			trLoaVO vo,HttpServletRequest req,
			@RequestParam("userid") String userid) {
		
		log.info("LostArk 거래작성완료");
		
		//사진저장부분
		files.forEach(file -> {
		log.info("---------------------");
		log.info("name : " + file.getOriginalFilename());
		log.info("size : " + file.getSize());
		vo.setFile("F:\\upload\\tmp"+file.getOriginalFilename());	
		
		File saveFile = new File("F:\\upload\\tmp\\", file.getOriginalFilename());
			
		try {
			file.transferTo(saveFile);
		} catch (Exception e) {
			log.info(e.getMessage());		
		}
		});
		//사진저장부분
		vo.setUserid(userid); //아이디 저장
		vo.setIp(req.getRemoteAddr()); //작성 아이피 저장
		log.info("저장 후 vo : "+vo);
			
		//글 작성 서비스동작
		service.trLoaboardCreate(vo);
			
		
		return "redirect:/ydTrBoard/trLostArk";
	}
	
	
	
	
	@RequestMapping(value="/trLostModify",method=RequestMethod.GET)
	public void gettrLostModify(Model model,HttpSession session,
			@RequestParam("num") int num) {
		
		log.info("trLostModify 거래글 수정페이지로 이동");
		
		//로아 최신뉴스 크롤링
		JSONArray LoaNews = service.getLoaNews();
		
		model.addAttribute("LoaNews", LoaNews);
		
		log.info(LoaNews+"");
		//로아 최신뉴스 크롤링
		
		//해당글내용 불러오기
		session.setAttribute("trLoa", service.getTrLoaContent(num));
		//해당글내용 불러오기
		
		
	}
	
	
	@RequestMapping(value="/trLostModify",method=RequestMethod.POST)
	public String posttrLostModify(Model model,HttpSession session,
			@RequestParam("num") int num,trLoaVO vo) {
		
		log.info("trLostModify 거래글 수정하기");
		
		
		//해당글내용 수정
		service.getTrLoaModify(vo);
		//해당글내용 수정
		
		return "redirect:/ydTrBoard/trLoaContent?num="+num;
	}
	
	
	@RequestMapping(value="/trLoadelete",method=RequestMethod.POST)
	public String posttrLoaDelete(@RequestParam("num") int num) {
		
		log.info("trLostModify 거래글 삭제하기");
		
		
		//해당글내용 수정
		service.getTrLoaDelete(num);
		//해당글내용 수정
		
		return "redirect:/ydTrBoard/trLostArk";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
