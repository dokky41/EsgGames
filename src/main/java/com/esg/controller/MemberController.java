package com.esg.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esg.domain.MemberVO;
import com.esg.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginGet() throws Exception {
		
		log.info("login페이지 실행");
	}
	
	@RequestMapping(value="/Register", method=RequestMethod.GET)
	public void joinGet() throws Exception {
		
		log.info("Register페이지 실행");
}
	
	@RequestMapping(value="/idCheck", method=RequestMethod.POST)
	@ResponseBody
	public int idCheck(@RequestParam("userid") String userid,Model model) throws Exception {
		
		log.info("userIdCheck 실행");
		log.info("전달받은 userid :" +userid);
		
		int cnt = service.idCheck(userid);
		
		model.addAttribute("cnt", cnt);
		
		log.info(cnt+"");
		
		return cnt;
}
	
	//회원가입
	@RequestMapping(value="/insertMember", method=RequestMethod.POST)
	public String inserMember(MemberVO vo,@RequestParam("chk") String chk,Model model) throws Exception {
		
		log.info("InsertMember 회원가입 실행");
		log.info(vo+"");
		
		
		if(chk.equals("1") ) {
			model.addAttribute("cc", "error");
			return "redirect:/member/Register";
		}
		
		service.memberInsert(vo);
		
		return "redirect:/member/login";
}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(MemberVO vo, HttpSession session) throws Exception {
		
		log.info("controller 로그인");
		log.info(vo+"");
		
		MemberVO membervo = service.loginCheck(vo);
		
		if(membervo==null) {
			return "redirect:/member/login";
		}
		
		session.setAttribute("membervo", membervo);
		
		return "redirect:/index";
	}
	//로그아웃
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logoutGET(HttpSession session) throws Exception {
		
		//로그아웃 => 세션정보 초기화
		session.invalidate();
		
		//페이지 이동
		return "redirect:/index";		
	}

}
