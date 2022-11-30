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
import com.esg.domain.esgMileVO;
import com.esg.domain.trLoaVO;
import com.esg.domain.trMailVO;
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
	
	
	//내 정보 페이지로 이동
	@RequestMapping(value="/myinfo", method=RequestMethod.GET)
	public void myinfoGET() throws Exception {
		
		log.info("내정보 페이지 이동");
	}
	
	//마일리지 충전 페이지로 이동
	@RequestMapping(value="/pointCharge", method=RequestMethod.GET)
	public void pointChargeGET(Model model) throws Exception {
		
		log.info("마일리지 충전 페이지 이동");

		//고유번호
		String chargeNum = service.searchCnum();
		
		model.addAttribute("chargeNum", chargeNum);
	}
	
	//마일리지 충전 동작
	@RequestMapping(value="/myPointCharge", method=RequestMethod.GET)
	public String myPointChargeGET(MemberVO vo,esgMileVO vo2) throws Exception {
			
		log.info("마일리지 충전 동작");
		
		log.info(vo+"");
		
		//회원 테이블 마일리지 충전
		service.myPointCharge(vo);
		
		//마일리지 테이블
		service.mileInsert(vo2);
		
		return "redirect:/member/myinfo";
	}
	
	//내 충전내역 페이지로 이동
	@RequestMapping(value="/myChargeInfo", method=RequestMethod.GET)
	public void myChargeInfoGET(esgMileVO vo,Model model) throws Exception {
		
		log.info("충전내역 페이지 이동");
		
		log.info(vo+"");
		
		log.info(service.getMyMileInfo(vo)+"");
		
		model.addAttribute("MMInfo", service.getMyMileInfo(vo));
		
	}
	
	
	//내 거래내역 페이지로 이동
	@RequestMapping(value="/myTradeInfo", method=RequestMethod.GET)
	public void myTradeInfoGET(Model model,@RequestParam("userid") String userid) throws Exception {
		
		log.info("유저아이디 : "+userid);
		
		log.info("거래내역 페이지 이동");
		
		//거래내역리스트
		log.info(service.getMyTrInfo(userid)+"");
		//거래내역리스트
			
		model.addAttribute("trInfo", service.getMyTrInfo(userid));
			
	}
	
	
	//내 고객센터 페이지로 이동
	@RequestMapping(value="/esgServiceCenter", method=RequestMethod.GET)
	public void esgServiceCenterGET() throws Exception {
		
		log.info("고객센터 페이지 이동");
		
		
	}
	
	@RequestMapping(value = "/trAgree", method = RequestMethod.POST)
	public String trAgree(trMailVO vo,MemberVO vo2,trLoaVO vo3,@RequestParam("bUserid") String bUserid) {
		
		log.info("trAgree 거래요청하기");
		
		//거래동의하기
		service.trUpdateMail(vo);
		//거래동의하기
		
		//거래마일리지가져오기
		log.info(vo3+"");
		log.info("거래마일리지 : " + service.tradeMileGet(vo3));
		//거래마일리지가져오기
		
		//판매자마일리지변환
		vo2.setUserpoint(service.tradeMileGet(vo3));
		log.info("판매자"+vo2+"");
		service.sellerMileTrans(vo2);
		//판매자마일리지변환
		
		//구매자마일리지변환
		vo2.setUserid(bUserid);
		vo2.setUserpoint(service.tradeMileGet(vo3));
		log.info("구매자"+vo2+"");
		service.buyerMileTrans(vo2);
		//구매자마일리지변환
		
		return "redirect:/member/myinfo";
	}

	
	
	//아이디찾기 페이지로 이동
	@RequestMapping(value="/idSearchForm", method=RequestMethod.GET)
	public void idSearchGET() throws Exception {
		
		
	}
	
	//비밀번호찾기 페이지로 이동
	@RequestMapping(value="/pwSearchForm", method=RequestMethod.GET)
	public void pwSearchGET() throws Exception {
			
			
	}

}
