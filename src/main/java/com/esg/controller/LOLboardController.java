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
	public ModelAndView boardList(LOLCriteria cri) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/LOLboard/boardList");	
		//페이징처리
		LOLPageMaker pageMaker = new LOLPageMaker();
	    pageMaker.setCri(cri);
	    
		List<LOLBoardVO> boardList = service.getBoardList(cri);
		pageMaker.setTotalCount(service.countBoardListTotal());
	    mav.addObject("boardList", boardList);
	    mav.addObject("pageMaker", pageMaker);
	    
		return mav;
	}
	
	//글 페이지 오픈
	@RequestMapping(value="/boardWrite",method = RequestMethod.GET)
	public void WriteGet() throws Exception{
		
		log.info("Write.jsp 실행");
		
	}
	
	//글 쓰기
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
	
	//글 본문 보기 + 글 조회수 증가
	@RequestMapping(value="/boardRead",method = RequestMethod.GET)
	public void readGet(@RequestParam("IDX") int num,Model model,LOLCriteria cri) throws Exception{
		log.info("read.jsp 실행");
		
		//조회수 증가
		service.updateBoardCount(num);
		log.info(num+"");
		//글 정보 가져오기
		LOLBoardVO read = service.readBoard(num);
		//파일 정보 가져오기
		List<Map<String, Object>> fileList = service.selectFileList(num);
		model.addAttribute("file", fileList);
		log.info(fileList+"");
		log.info(read+"");

		//가져온 데이터를 연결된 뷰페이지에 출력
		model.addAttribute("vo",read);
		
		//페이징 처리
		LOLPageMaker pageMaker = new LOLPageMaker();
        pageMaker.setCri(cri);
        model.addAttribute("page",cri.getPage());
        model.addAttribute("pageMaker", pageMaker);
	}
	
	//상세정보를 가져와 "detail"란 이름에 저장
	@RequestMapping(value="/boardUpdate",method = RequestMethod.GET)
	public void UpdateGet(@RequestParam("IDX") int num,Model model,LOLCriteria cri) throws Exception{
		
		log.info("Update.jsp 실행");
		LOLBoardVO detail=service.readBoard(num);
		model.addAttribute("detail",detail);
		
		LOLPageMaker pageMaker = new LOLPageMaker();
		pageMaker.setCri(cri);
        model.addAttribute("page",cri.getPage());
        model.addAttribute("pageMaker", pageMaker);
	}

	//글 수정 업데이트
	@RequestMapping(value="/boardUpdate",method = RequestMethod.POST)
    public String boardUpdatePost (LOLBoardVO vo,LOLCriteria cri,RedirectAttributes redAttr) throws Exception {
        log.info(vo+"");
        service.update(vo);
        
        redAttr.addAttribute("page", cri.getPage());
        redAttr.addAttribute("perPagNum", cri.getPerPageNum());
        
        return "redirect:/LOLboard/boardList";
    }
	
	//글 삭제 IDX 저장
	@RequestMapping(value="/boardDelete",method = RequestMethod.GET)
	public String DeletePOST(@RequestParam("IDX") int num,LOLCriteria cri,RedirectAttributes redAttr) throws Exception{
			log.info(num+"delete");
			service.deleteBoard(num);
			
			//페이징 처리
			redAttr.addAttribute("page", cri.getPage());
			redAttr.addAttribute("perPagNum", cri.getPerPageNum());
		     
			return "redirect:/LOLboard/boardList";
	}
}
