package com.esg.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.esg.domain.MemberVO;
import com.esg.domain.addressVO;
import com.esg.domain.esgChange;
import com.esg.domain.esgMileVO;
import com.esg.domain.esgmailVO;
import com.esg.domain.trLoaVO;
import com.esg.domain.trMailVO;
import com.esg.service.MemberService;
import com.esg.sms.ydTrPwSms;
import com.esg.sms.ydTrSms;

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
	public String inserMember(addressVO vo2,MemberVO vo,@RequestParam("chk") String chk,Model model) throws Exception {
		
		log.info("InsertMember 회원가입 실행");
		log.info(vo+"");
		
		
		if(chk.equals("1") ) {
			model.addAttribute("cc", "error");
			return "redirect:/member/Register";
		}
		//주소합쳐서 저장
		String address=vo2.getAddress2()+vo2.getAddress2()+vo2.getAddress3()+vo2.getAddress4();
		vo.setAddress(address);
		//주소합쳐서 저장
		
		service.memberInsert(vo);
		
		return "redirect:/member/login";
}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(esgMileVO vo2,MemberVO vo, HttpSession session) throws Exception {
		
		log.info("controller 로그인");
		log.info(vo+"");
		
		MemberVO membervo = service.loginCheck(vo);
		
		if(membervo==null) {
			return "redirect:/member/login";
		}
		
		vo2.setUserid(vo.getUserid());
		
		List<esgMileVO> mile = service.getMyMileInfo(vo2);
		List<trMailVO> trInfo = service.getMyTrInfo(membervo.getUserid());
		List<trMailVO> trFromInfo = service.getFromTrInfo(membervo.getUserid());
		List<trMailVO> trToInfo = service.getToTrInfo(membervo.getUserid());
		List<trMailVO> mailFrom = service.getmailForm(membervo.getUserid());
		List<trMailVO> mailTo = service.getmailTo(membervo.getUserid());
		
		
		session.setAttribute("mailFrom", mailFrom);
		session.setAttribute("mailTo", mailTo);
		session.setAttribute("trToInfo", trToInfo);
		session.setAttribute("trFromInfo", trFromInfo);
		session.setAttribute("membervo", membervo);
		session.setAttribute("mile", mile);
		session.setAttribute("tr", trInfo);
		
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
	public void myinfoGET(esgMileVO vo2, HttpSession session,@RequestParam("userid") String userid,
			Model model,@RequestParam("sort") String sort) throws Exception {
		
		log.info("내정보 페이지 이동");
		
		model.addAttribute("sort", sort);
//	    
	    log.info(userid);
		
		vo2.setUserid(userid);
		
		List<esgMileVO> mile = service.getMyMileInfo(vo2);
		List<trMailVO> trInfo = service.getMyTrInfo(userid);
		List<trMailVO> trFromInfo = service.getFromTrInfo(userid);
		List<trMailVO> trToInfo = service.getToTrInfo(userid);
		List<trMailVO> mailFrom = service.getmailForm(userid);
		List<trMailVO> mailTo = service.getmailTo(userid);
//		
//		
		session.setAttribute("mailFrom", mailFrom);
		session.setAttribute("mailTo", mailTo);
		session.setAttribute("trToInfo", trToInfo);
		session.setAttribute("trFromInfo", trFromInfo);
		session.setAttribute("mile", mile);
		session.setAttribute("tr", trInfo);
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
	public void myPointChargeGET(MemberVO vo,esgMileVO vo2,trLoaVO vo3) throws Exception {
			
		log.info("마일리지 충전 동작");
		
		log.info(vo+"");
		
		vo2.setChargeNum(service.searchCnum());
		
		//회원 테이블 마일리지 충전
		service.myPointCharge(vo);
		
		//마일리지 테이블
		service.mileInsert(vo2);
		
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
		
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/trRefuse", method = RequestMethod.GET)
	public String trRefuse(trMailVO vo) {
		
		log.info("trRefuse 거래 거절하기");
		
		vo.setTrState("no");
		
		log.info(vo+"");
		
		service.getRefuse(vo);
		
		
		
		return "redirect:/index";
	}

	//본인인증 메세지
	@RequestMapping(value="/inju", method=RequestMethod.POST)
	@ResponseBody
	public String injuPOST(Model model,@RequestParam("phNum") String phNum) throws Exception {
			
			//문자보내보기
			String inJMail=service.smsShoot(phNum);
			
			log.info(inJMail);

			//문자보내보기
			model.addAttribute("inNum", inJMail);
			
			return inJMail;
	}
	
	
	//아이디찾기 페이지로 이동
	@RequestMapping(value="/idSearchForm", method=RequestMethod.GET)
	public void idSearchGET() throws Exception {
		
		
	}
	//아이디찾기 동작
	@RequestMapping(value="/idSearchForm", method=RequestMethod.POST)
	public String idSearchPOST(MemberVO vo,Model model) throws Exception {
		
		log.info("아이디 찾기 동작");
		log.info("가져온항목"+vo);
		
		//아이디가져오기
		String idLook = service.getIdSearch(vo);
		//아이디가져오기
		
		log.info("결과 : "+idLook);
		
		model.addAttribute("idLook", idLook);
		
		return "forward:/member/myId?idLook="+idLook;
	}
	
	@RequestMapping(value="/myId", method=RequestMethod.POST)
	public void myIdGET(Model model,@RequestParam("idLook") String idLook) throws Exception {
		
		log.info("아이디 찾기 결과 페이지");
		
		model.addAttribute("idLook", idLook);
		
	}
	
	
	
	//비밀번호찾기 페이지로 이동
	@RequestMapping(value="/pwSearchForm", method=RequestMethod.GET)
	public void pwSearchGET() throws Exception {
			
			
	}
	
	//비밀번호찾기 동작
	@RequestMapping(value="/pwSearchForm", method=RequestMethod.POST)
	public String pwSearchPOST(MemberVO vo) throws Exception {
			
		log.info("비밀번호 찾기 동작");
		log.info("가져온항목"+vo);
			
		//아이디가져오기
		String pwLook = service.getPwSearch(vo);
		//아이디가져오기
			
		log.info("결과 : "+pwLook);
		
		if(pwLook.equals("0")) {
			return "redirect:/member/rePwSearch";
		}
		//비밀번호 재발급
		String newPw = ydTrPwSms.aa(vo.getPhNum());
		log.info(newPw);
		vo.setUserpw(newPw);
		service.updateRePw(vo);
		//비밀번호 재발급
			
		return "redirect:/member/login";
	}
	
	
	//비밀번호찾기 페이지로 이동
	@RequestMapping(value="/rePwSearch", method=RequestMethod.GET)
	public void rePwSearchGET() throws Exception {
				
				
	}
	
	//내정보변경 페이지로 이동
	@RequestMapping(value="/myinfoUpdate", method=RequestMethod.GET)
	public void myinfoUpdateGET() throws Exception {
		
		
	}
	
	//내정보변경 
	@RequestMapping(value="/updateMeInfo", method=RequestMethod.POST)
	public String updateInfoPOST(MemberVO vo) throws Exception {
		
		service.updateMeInfo(vo);
		
		
		return "redirect:/member/login";
	}
	
	//내정보삭제 
	@RequestMapping(value="/deleteMeInfo", method=RequestMethod.POST)
	public String deleteMeInfoPOST(MemberVO vo) throws Exception {
		
		service.deleteMeInfo(vo);
		
		
		return "redirect:/member/login";
	}
	
	//마일리지 환불
	@RequestMapping(value="/exChangeDB", method=RequestMethod.POST)
	public void exChangeDBPOST(esgChange vo) throws Exception {
		
		//환불아임포트
		service.payExChange(vo);
		
		//환불테이블
		service.exPutDB(vo);
		
		//마일리지 업데이트
		service.exMileTrans(vo);
		
	}
	
	//메일보내기
	@RequestMapping(value="/mailSend", method=RequestMethod.POST)
	public String mailSendPOST(esgmailVO vo) throws Exception {
		
		service.sendMail(vo);
		
		
		return "redirect:/index";
	}

}
