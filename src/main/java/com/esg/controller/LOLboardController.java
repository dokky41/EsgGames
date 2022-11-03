package com.esg.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.esg.domain.LOLBoardVO;
import com.esg.persistence.LOLBoardDAO;
import com.esg.service.LOLBoardService;

@Controller
@RequestMapping("/LOLboard/*")

public class LOLboardController {
	
	private static final Logger log = LoggerFactory.getLogger(LOLboardController.class);
	
	@Inject
	LOLBoardService service;
	
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public ModelAndView boardList() throws Exception{
		
		ModelAndView model = new ModelAndView();
		model.setViewName("/LOLboard/boardList");
		
		List<LOLBoardVO> boardList = service.getBoardList();
		model.addObject("boardList", boardList);
		
		return model;
	}
	
	@RequestMapping(value="/boardWrite",method = RequestMethod.GET)
	public void WriteGet() throws Exception{
		
		log.info("Write.jsp ½ÇÇà");
		
	}

	@RequestMapping(value="/boardWrite",method = RequestMethod.POST)
    public ModelAndView boardWritePost (LOLBoardVO vo) throws Exception {
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/LOLboard/boardList");
        log.info(vo+"");
        service.insertBoard(vo);
        log.info(model+"");
        return model;
    }

	
}
