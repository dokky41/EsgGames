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
import com.esg.domain.LOLSearchCriteria;
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
	//湲� 紐⑸줉
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public ModelAndView boardList(@ModelAttribute("cri")LOLSearchCriteria cri) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/LOLboard/boardList");	
		
		//�럹�씠吏뺤쿂由�
		LOLPageMaker pageMaker = new LOLPageMaker();
	    pageMaker.setCri(cri);
	    
		List<LOLBoardVO> boardList = service.getBoardList(cri);

		
		pageMaker.setTotalCount(service.countBoardListTotal(cri));
	    mav.addObject("boardList", boardList);
	    mav.addObject("pageMaker", pageMaker);
	    
		return mav;
	}
	
	//湲� �럹�씠吏� �삤�뵂
	@RequestMapping(value="/boardWrite",method = RequestMethod.GET)
	public void WriteGet() throws Exception{
		
		log.info("Write.jsp �떎�뻾");
		
	}
	
	//湲� �벐湲�
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
	
	//湲� 蹂몃Ц 蹂닿린 + 湲� 議고쉶�닔 利앷�
	@RequestMapping(value="/boardRead",method = RequestMethod.GET)
	public void readGet(@RequestParam("IDX") int num,Model model,@ModelAttribute("cri")LOLSearchCriteria cri,LOLReplyVO revo) throws Exception{
		log.info("read.jsp �떎�뻾");
		
		//議고쉶�닔 利앷�
		service.updateBoardCount(num);
		log.info(num+"");
		//湲� �젙蹂� 媛��졇�삤湲�
		LOLBoardVO read = service.readBoard(num);
		//�뙆�씪 �젙蹂� 媛��졇�삤湲�
		List<Map<String, Object>> fileList = service.selectFileList(num);
		model.addAttribute("file", fileList);
		log.info(fileList+"");
		log.info(read+"");

		//媛��졇�삩 �뜲�씠�꽣瑜� �뿰寃곕맂 酉고럹�씠吏��뿉 異쒕젰
		model.addAttribute("vo",read);
		
		//�럹�씠吏� 泥섎━
		LOLPageMaker pageMaker = new LOLPageMaker();
        pageMaker.setCri(cri);
        model.addAttribute("page",cri.getPage());
        model.addAttribute("pageMaker", pageMaker);
        
        //
        model.addAttribute("cri",cri);
        // �뙎湲� 議고쉶
        List<LOLReplyVO> reply = replyservice.list(num);
        
        model.addAttribute("qreply", reply);
        model.addAttribute("reply", reply);
	}
	
	//�긽�꽭�젙蹂대�� 媛��졇�� "detail"�� �씠由꾩뿉 ���옣
	@RequestMapping(value="/boardUpdate",method = RequestMethod.GET)
	public void UpdateGet(@RequestParam("IDX") int num,Model model,@ModelAttribute("cri")LOLSearchCriteria cri) throws Exception{
		
		log.info("Update.jsp �떎�뻾");
		LOLBoardVO detail=service.readBoard(num);
		model.addAttribute("detail",detail);
		//
        model.addAttribute("cri",cri);
        
		LOLPageMaker pageMaker = new LOLPageMaker();
		pageMaker.setCri(cri);
        model.addAttribute("page",cri.getPage());
        model.addAttribute("pageMaker", pageMaker);
	}

	//湲� �닔�젙 �뾽�뜲�씠�듃
	@RequestMapping(value="/boardUpdate",method = RequestMethod.POST)
    public String boardUpdatePost (LOLBoardVO vo,@ModelAttribute("cri")LOLSearchCriteria cri,RedirectAttributes rttr) throws Exception {
        log.info(vo+"");
        service.update(vo);
        
        rttr.addAttribute("page", cri.getPage());
        rttr.addAttribute("perPagNum", cri.getPerPageNum());
        rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
        return "redirect:/LOLboard/boardList";
    }
	
	//湲� �궘�젣 IDX ���옣
	@RequestMapping(value="/boardDelete",method = RequestMethod.GET)
	public String DeleteGet(@RequestParam("IDX") int num,@ModelAttribute("cri")LOLSearchCriteria cri,RedirectAttributes rttr) throws Exception{
			log.info(num+"delete");
			service.deleteBoard(num);
			
			//�럹�씠吏� 泥섎━
			rttr.addAttribute("page", cri.getPage());
			rttr.addAttribute("perPagNum", cri.getPerPageNum());
			rttr.addAttribute("searchType", cri.getSearchType());
			rttr.addAttribute("keyword", cri.getKeyword());
			
			return "redirect:/LOLboard/boardList";
	}
	//湲� 異붿쿇�닔
	@RequestMapping(value="/boardRecommend",method = RequestMethod.GET)
	public String RecommendGet(@RequestParam("IDX") int num,LOLCriteria cri,LOLBoardVO vo) throws Exception{
			log.info(num+"boardRecommend");
			service.recommend(num);
			
		     
			return "redirect:/LOLboard/boardRead?IDX="+vo.getIDX()+"&page="+cri.getPage()+"&perPageNum="+cri.getPerPageNum();
	}
	
	
}
