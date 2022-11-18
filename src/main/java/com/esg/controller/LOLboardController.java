package com.esg.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.esg.domain.LOLBoardVO;
import com.esg.domain.LOLCriteria;
import com.esg.domain.LOLPageMaker;
import com.esg.domain.LOLReplyVO;
import com.esg.persistence.LOLBoardDAO;
import com.esg.service.LOLBoardService;
import com.esg.service.LOLReplyService;

@Controller
@RequestMapping("/LOLboard/*")

public class LOLboardController {
	
	private static final Logger log = LoggerFactory.getLogger(LOLboardController.class);
	
	@Inject
	LOLBoardService service;
	
	@Inject
	LOLReplyService replyservice;
	//�� ���
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public ModelAndView boardList(LOLCriteria cri) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/LOLboard/boardList");	
		//����¡ó��
		LOLPageMaker pageMaker = new LOLPageMaker();
	    pageMaker.setCri(cri);
	    
		List<LOLBoardVO> boardList = service.getBoardList(cri);
		pageMaker.setTotalCount(service.countBoardListTotal());
	    mav.addObject("boardList", boardList);
	    mav.addObject("pageMaker", pageMaker);
	    
		return mav;
	}
	
	//�� ������ ����
	@RequestMapping(value="/boardWrite",method = RequestMethod.GET)
	public void WriteGet() throws Exception{
		
		log.info("Write.jsp ����");
		
	}
	
	//�� ����
	@RequestMapping(value="/boardWrite",method = RequestMethod.POST)
    public ModelAndView boardWritePost (LOLBoardVO vo,MultipartFile[] file) throws Exception {
        ModelAndView mav = new ModelAndView();
        
        mav.setViewName("redirect:/LOLboard/boardList");
        log.info(vo+"");
        
        if((file[0].getOriginalFilename()).equals("")) {
        service.insertBoard(vo);
        }
        else{
        service.insertBoard(vo,file);
        }
        
        return mav;
    }
	
	//�� ���� ���� + �� ��ȸ�� ����
	@RequestMapping(value="/boardRead",method = RequestMethod.GET)
	public void readGet(@RequestParam("IDX") int num,Model model,LOLCriteria cri) throws Exception{
		log.info("read.jsp ����");
		
		//��ȸ�� ����
		service.updateBoardCount(num);
		log.info(num+"");
		//�� ���� ��������
		LOLBoardVO read = service.readBoard(num);
		//���� ���� ��������
		List<Map<String, Object>> fileList = service.selectFileList(num);
		model.addAttribute("file", fileList);
		log.info(fileList+"");
		log.info(read+"");

		//������ �����͸� ����� ���������� ���
		model.addAttribute("vo",read);
		
		//����¡ ó��
		LOLPageMaker pageMaker = new LOLPageMaker();
        pageMaker.setCri(cri);
        model.addAttribute("page",cri.getPage());
        model.addAttribute("pageMaker", pageMaker);
        
        // ��� ��ȸ
        List<LOLReplyVO> reply;
        reply = replyservice.list(num);
        model.addAttribute("reply", reply);
	}
	
	//�������� ������ "detail"�� �̸��� ����
	@RequestMapping(value="/boardUpdate",method = RequestMethod.GET)
	public void UpdateGet(@RequestParam("IDX") int num,Model model,LOLCriteria cri) throws Exception{
		
		log.info("Update.jsp ����");
		LOLBoardVO detail=service.readBoard(num);
		model.addAttribute("detail",detail);
		
		LOLPageMaker pageMaker = new LOLPageMaker();
		pageMaker.setCri(cri);
        model.addAttribute("page",cri.getPage());
        model.addAttribute("pageMaker", pageMaker);
	}

	//�� ���� ������Ʈ
	@RequestMapping(value="/boardUpdate",method = RequestMethod.POST)
    public String boardUpdatePost (LOLBoardVO vo,LOLCriteria cri,RedirectAttributes redAttr) throws Exception {
        log.info(vo+"");
        service.update(vo);
        
        redAttr.addAttribute("page", cri.getPage());
        redAttr.addAttribute("perPagNum", cri.getPerPageNum());
        
        return "redirect:/LOLboard/boardList";
    }
	
	//�� ���� IDX ����
	@RequestMapping(value="/boardDelete",method = RequestMethod.GET)
	public String DeletePOST(@RequestParam("IDX") int num,LOLCriteria cri,RedirectAttributes redAttr) throws Exception{
			log.info(num+"delete");
			service.deleteBoard(num);
			
			//����¡ ó��
			redAttr.addAttribute("page", cri.getPage());
			redAttr.addAttribute("perPagNum", cri.getPerPageNum());
		     
			return "redirect:/LOLboard/boardList";
	}
}