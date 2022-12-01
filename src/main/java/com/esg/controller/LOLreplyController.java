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
	
	// ��� �ۼ�
	@RequestMapping(value = "/replyWrite", method = RequestMethod.POST)
	public String WritePost(LOLReplyVO vo,LOLCriteria cri,RedirectAttributes rttr) throws Exception {
        
        replyservice.write(vo);
		log.info(vo+"");
		
		
		return "redirect:/LOLboard/boardRead?IDX=" + vo.getIDX()+"&page="+cri.getPage()+"&perPageNum="+cri.getPerPageNum();
	}
	@RequestMapping(value = "/RreplyWrite", method = RequestMethod.GET)
	public void RreplyWrite(@RequestParam("IDX") int num,@RequestParam("RNO") int RNO, Model model) throws Exception {
		
		LOLReplyVO vo = new LOLReplyVO();
		vo.setIDX(num);
		vo.setRNO(RNO);
		model.addAttribute("reply", vo);
	}

	@RequestMapping(value = "/RreplyWrite", method = RequestMethod.POST)
	public String RreplyWriteP(LOLReplyVO vo,LOLCriteria cri) throws Exception {
		replyservice.Rwrite(vo);
		return "redirect:/LOLboard/boardRead?IDX=" + vo.getIDX()+"&page="+cri.getPage()+"&perPageNum="+cri.getPerPageNum();
	}
	
	// ��� ���� ��ȸ (���� ������)
	@RequestMapping(value = "/replyUpdate", method = RequestMethod.GET)
	public void getMofidy(@RequestParam("IDX") int num,@RequestParam("RNO") int RNO, Model model) throws Exception {
		
		LOLReplyVO vo = new LOLReplyVO();
		vo.setIDX(num);
		vo.setRNO(RNO);
		
		LOLReplyVO reply = replyservice.replySelect(vo);
			 
		model.addAttribute("reply", reply);
	}
	// ��� ����
	@RequestMapping(value = "/replyUpdate", method = RequestMethod.POST)
	public String postModify(LOLReplyVO vo,LOLCriteria cri) throws Exception {

		replyservice.update(vo);

		return "redirect:/LOLboard/boardRead?IDX=" + vo.getIDX()+"&page="+cri.getPage()+"&perPageNum="+cri.getPerPageNum();
	}
	
	//��� ����
	@RequestMapping(value="/replyDelete",method = RequestMethod.GET)
	public String DeleteGET(LOLReplyVO vo,LOLCriteria cri) throws Exception{
		log.info("delete ����");
		replyservice.delete(vo);
				
			     
		return "redirect:/LOLboard/boardRead?IDX=" + vo.getIDX()+"&page="+cri.getPage()+"&perPageNum="+cri.getPerPageNum();
	}
	
	//�� ��õ��
	@RequestMapping(value="/replyRecommend",method = RequestMethod.GET)
	public String rRecommendGet(@RequestParam("RNO") int num,LOLCriteria cri,LOLReplyVO vo) throws Exception{
			log.info(num+"");
			replyservice.recommend(num);
			
		     
			return "redirect:/LOLboard/boardRead?IDX="+vo.getIDX()+"&page="+cri.getPage()+"&perPageNum="+cri.getPerPageNum();
	}
}
