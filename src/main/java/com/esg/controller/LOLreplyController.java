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
	
	// ¥Ò±€ ¿€º∫
	@RequestMapping(value = "/replyWrite", method = RequestMethod.POST)
	public ModelAndView postWirte(LOLReplyVO vo,LOLCriteria cri) throws Exception {
		ModelAndView mav = new ModelAndView();
        
        mav.setViewName("redirect:/LOLboard/boardRead?IDX=" + vo.getIDX()+"&page="+cri.getPage()+"&perPageNum="+cri.getPerPageNum());
        replyservice.write(vo);
		log.info(vo+"");
		return mav;
	}
}
