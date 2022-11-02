package com.esg.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esg.domain.MemberVO;
import com.esg.service.MemberService;


public class MemberController {
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginGet() throws Exception {
		
		log.info("login페이지 실행");
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public void joinGet() throws Exception {
		
		log.info("join페이지 실행");
}
	
	@RequestMapping(value="/idCheck", method=RequestMethod.POST)
	@ResponseBody
	public int idCheck(@RequestParam("userid") String userid) throws Exception {
		
		log.info("userIdCheck 실행");
		log.info("전달받은 userid :" +userid);
		
		int cnt = service.idCheck(userid);
		
		return cnt;
}
	
	//회원가입
	@RequestMapping(value="/insertMember", method=RequestMethod.POST)
	public String inserMember(MemberVO vo) throws Exception {
		
		log.info("InsertMember 회원가입 실행");
		log.info(vo+"");
		
		
		service.memberInsert(vo);
		
		return "redirect:/board/member/login";
}
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(MemberVO vo, HttpSession session) throws Exception {
		
		log.info("controller 로그인");
		
		MemberVO membervo = service.loginCheck(vo);
		
		if(membervo==null) {
			return "redirect:/board/member/login";
		}
		
		session.setAttribute("membervo", membervo);
		
		return "redirect:/board/index";
	}
	//로그아웃
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public String logoutGET(HttpSession session) throws Exception {
		
		//로그아웃 => 세션정보 초기화
		session.invalidate();
		
		//페이지 이동
		return "redirect:/board/index";		
	}

}
