package com.esg.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.esg.domain.LOACriteria;
import com.esg.domain.LOAReplyVO;
import com.esg.service.LOAReplyService;

@Controller
@RequestMapping("/LOAreply/*")
public class LOAreplyController {
	private static final Logger log = LoggerFactory.getLogger(LOAreplyController.class);
	@Inject
	private LOAReplyService replyservice;
	
	// 댓글 작성
	@RequestMapping(value = "/replyWrite", method = RequestMethod.POST)
	public String WritePost(LOAReplyVO vo,LOACriteria cri,RedirectAttributes rttr) throws Exception {
        
        replyservice.write(vo);
		log.info(vo+"");
		rttr.addAttribute("IDX", vo.getIDX());
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		
		return "redirect:/LOAboard/boardRead";
	}
	@RequestMapping(value = "/RreplyWrite", method = RequestMethod.GET)
	public void RreplyWrite(@RequestParam("IDX") int num,@RequestParam("RNO") int RNO, Model model) throws Exception {
		
		LOAReplyVO vo = new LOAReplyVO();
		vo.setIDX(num);
		vo.setRNO(RNO);
		model.addAttribute("reply", vo);
	}

	@RequestMapping(value = "/RreplyWrite", method = RequestMethod.POST)
	public String RreplyWriteP(LOAReplyVO vo,LOACriteria cri) throws Exception {
		replyservice.Rwrite(vo);
		return "redirect:/LOAboard/boardRead?IDX=" + vo.getIDX()+"&page="+cri.getPage()+"&perPageNum="+cri.getPerPageNum();
	}
	
	// 댓글 단일 조회 (수정 페이지)
	@RequestMapping(value = "/replyUpdate", method = RequestMethod.GET)
	public void getMofidy(@RequestParam("IDX") int num,@RequestParam("RNO") int RNO, Model model) throws Exception {
		
		LOAReplyVO vo = new LOAReplyVO();
		vo.setIDX(num);
		vo.setRNO(RNO);
		
		LOAReplyVO reply = replyservice.replySelect(vo);
			 
		model.addAttribute("reply", reply);
	}
	// 댓글 수정
	@RequestMapping(value = "/replyUpdate", method = RequestMethod.POST)
	public String postModify(LOAReplyVO vo,LOACriteria cri) throws Exception {

		replyservice.update(vo);

		return "redirect:/LOAboard/boardRead?IDX=" + vo.getIDX()+"&page="+cri.getPage()+"&perPageNum="+cri.getPerPageNum();
	}
	
	//댓글 삭제
	@RequestMapping(value="/replyDelete",method = RequestMethod.GET)
	public String DeleteGET(LOAReplyVO vo,LOACriteria cri) throws Exception{
		log.info("delete 실행");
		replyservice.delete(vo);
				
			     
		return "redirect:/LOAboard/boardRead?IDX=" + vo.getIDX()+"&page="+cri.getPage()+"&perPageNum="+cri.getPerPageNum();
	}
	
	//글 추천수
	@RequestMapping(value="/replyRecommend",method = RequestMethod.GET)
	public String rRecommendGet(@RequestParam("RNO") int num,LOACriteria cri,LOAReplyVO vo) throws Exception{
			log.info(num+"");
			replyservice.recommend(num);
			
		     
			return "redirect:/LOAboard/boardRead?IDX="+vo.getIDX()+"&page="+cri.getPage()+"&perPageNum="+cri.getPerPageNum();
	}
}
