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
	//�� ���
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public ModelAndView boardList() throws Exception{
		
		ModelAndView model = new ModelAndView();
		model.setViewName("/LOLboard/boardList");
		
		List<LOLBoardVO> boardList = service.getBoardList();
		model.addObject("boardList", boardList);
		
		return model;
	}
	//�� ������ ����
	@RequestMapping(value="/boardWrite",method = RequestMethod.GET)
	public void WriteGet() throws Exception{
		
		log.info("Write.jsp ����");
		
	}
	//�� ����
	@RequestMapping(value="/boardWrite",method = RequestMethod.POST)
    public ModelAndView boardWritePost (LOLBoardVO vo) throws Exception {
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/LOLboard/boardList");
        log.info(vo+"");
        service.insertBoard(vo);
        log.info(model+"");
        return model;
    }
	
	//�� ���� ���� + �� ��ȸ�� ����
	@RequestMapping(value="/boardRead",method = RequestMethod.GET)
	public void readGet(@RequestParam("IDX") int num,Model model) throws Exception{
		log.info("read.jsp ����");
		
		//��ȸ�� ����
		service.updateBoardCount(num);
		log.info(num+"");
		//�� ���� ��������
		LOLBoardVO vo = service.readBoard(num);
		
		//������ �����͸� ����� ���������� ���
		model.addAttribute("vo",vo);
	}
	//�������� ������ "detail"�� �̸��� ����
	@RequestMapping(value="/boardUpdate",method = RequestMethod.GET)
	public void UpdateGet(@RequestParam("IDX") int num,Model model) throws Exception{
		
		log.info("Update.jsp ����");
		LOLBoardVO detail=service.readBoard(num);
		model.addAttribute("detail",detail);
	}

	//�� ���� ������Ʈ
	@RequestMapping(value="/boardUpdate",method = RequestMethod.POST)
    public String boardUpdatePost (LOLBoardVO vo) throws Exception {
        log.info(vo+"");
        service.update(vo);
        return "redirect:/LOLboard/boardList";
    }
	//�� ���� IDX ����
		@RequestMapping(value="/boardDelete",method = RequestMethod.GET)
		public String DeletePOST(@RequestParam("IDX") int num) throws Exception{
			log.info(num+"delete");
			service.deleteBoard(num);
			return "redirect:/LOLboard/boardList";
		}
}
