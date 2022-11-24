package com.esg.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.esg.domain.LOLBoardVO;
import com.esg.domain.LOLCriteria;
import com.esg.domain.LOLPageMaker;
import com.esg.domain.LOLReplyVO;
import com.esg.service.LOLReplyService;

@Controller
@RequestMapping("/LOLreply/*")
public class LOLreplyController {
	
	private static final Logger log = LoggerFactory.getLogger(LOLreplyController.class);
	@Inject
	private LOLReplyService replyservice;
	
	// 댓글 작성
	@RequestMapping(value = "/replyWrite", method = RequestMethod.POST)
	public String WritePost(LOLReplyVO vo,LOLCriteria cri,RedirectAttributes rttr) throws Exception {
        
        replyservice.write(vo);
		log.info(vo+"");
		
		rttr.addAttribute("IDX", vo.getIDX());
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		
		return "redirect:/LOLboard/boardRead?IDX=" + vo.getIDX()+"&page="+cri.getPage()+"&perPageNum="+cri.getPerPageNum();
	}
	
	// 댓글 단일 조회 (수정 페이지)
	@RequestMapping(value = "/replyUpdate", method = RequestMethod.GET)
	public void getMofidy(@RequestParam("IDX") int num,@RequestParam("RNO") int RNO, Model model) throws Exception {
		
		LOLReplyVO vo = new LOLReplyVO();
		vo.setIDX(num);
		vo.setRNO(RNO);
		
		LOLReplyVO reply = replyservice.replySelect(vo);
			 
		model.addAttribute("reply", reply);
	}
	// 댓글 수정
	@RequestMapping(value = "/replyUpdate", method = RequestMethod.POST)
	public String postModify(LOLReplyVO vo,LOLCriteria cri) throws Exception {

		replyservice.update(vo);

		return "redirect:/LOLboard/boardRead?IDX=" + vo.getIDX()+"&page="+cri.getPage()+"&perPageNum="+cri.getPerPageNum();
	}
	
	//댓글 삭제
	@RequestMapping(value="/replyDelete",method = RequestMethod.GET)
	public String DeleteGET(LOLReplyVO vo,LOLCriteria cri) throws Exception{
		log.info("delete 실행");
		replyservice.delete(vo);
				
			     
		return "redirect:/LOLboard/boardRead?IDX=" + vo.getIDX()+"&page="+cri.getPage()+"&perPageNum="+cri.getPerPageNum();
	}
		
}
