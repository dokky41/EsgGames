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
	//글 목록
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public ModelAndView boardList() throws Exception{
		
		ModelAndView model = new ModelAndView();
		model.setViewName("/LOLboard/boardList");
		
		List<LOLBoardVO> boardList = service.getBoardList();
		model.addObject("boardList", boardList);
		
		return model;
	}
	//글 페이지 오픈
	@RequestMapping(value="/boardWrite",method = RequestMethod.GET)
	public void WriteGet() throws Exception{
		
		log.info("Write.jsp 실행");
		
	}
	//글 쓰기
	@RequestMapping(value="/boardWrite",method = RequestMethod.POST)
    public ModelAndView boardWritePost (LOLBoardVO vo) throws Exception {
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/LOLboard/boardList");
        log.info(vo+"");
        service.insertBoard(vo);
        log.info(model+"");
        return model;
    }
	
	//글 본문 보기 + 글 조회수 증가
	@RequestMapping(value="/boardRead",method = RequestMethod.GET)
	public void readGet(@RequestParam("IDX") int num,Model model) throws Exception{
		log.info("read.jsp 실행");
		
		//조회수 증가
		service.updateBoardCount(num);
		log.info(num+"");
		//글 정보 가져오기
		LOLBoardVO vo = service.readBoard(num);
		
		//가져온 데이터를 연결된 뷰페이지에 출력
		model.addAttribute("vo",vo);
	}
	//상세정보를 가져와 "detail"란 이름에 저장
	@RequestMapping(value="/boardUpdate",method = RequestMethod.GET)
	public void UpdateGet(@RequestParam("IDX") int num,Model model) throws Exception{
		
		log.info("Update.jsp 실행");
		LOLBoardVO detail=service.readBoard(num);
		model.addAttribute("detail",detail);
	}

	//글 수정 업데이트
	@RequestMapping(value="/boardUpdate",method = RequestMethod.POST)
    public String boardUpdatePost (LOLBoardVO vo) throws Exception {
        log.info(vo+"");
        service.update(vo);
        return "redirect:/LOLboard/boardList";
    }
	//글 삭제 IDX 저장
		@RequestMapping(value="/boardDelete",method = RequestMethod.GET)
		public String DeletePOST(@RequestParam("IDX") int num) throws Exception{
			log.info(num+"delete");
			service.deleteBoard(num);
			return "redirect:/LOLboard/boardList";
		}
}
