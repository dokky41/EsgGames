package com.esg.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.esg.controller.BGboardController;
import com.esg.domain.BGFileVO;
import com.esg.domain.BGboardVO;
import com.esg.domain.Criteria;
import com.esg.domain.PageMaker;
import com.esg.service.BGboardService;



@Controller
@RequestMapping("/battlegrounds/*")
public class BGboardController {
	
	private static final Logger log = LoggerFactory.getLogger(BGboardController.class);
	
	@Inject
	BGboardService service;
	
	@RequestMapping(value="/battlegrounds/BGboardlist",method=RequestMethod.GET)
	public void BGGet(Model model,Criteria cri) throws Exception {
		
		log.info("battlegrounds페이지 실행");
		List<BGboardVO> BGlist = service.BGboardlist(cri);
		log.info(""+service.BGboardlist(cri));
		model.addAttribute("BGlist", BGlist);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		pageMaker.setTotalCount(service.totalCnt());
		
		model.addAttribute("pm",pageMaker);
		
	}
	
	@RequestMapping(value="/battlegrounds/BGboardwrite",method=RequestMethod.GET)
	public void BG1Get() throws Exception{
		
		log.info("글쓰기페이지 실행");
	}
	
	@RequestMapping(value="/battlegrounds/BGboardwrite", method=RequestMethod.POST)
	public ModelAndView BG2Post(BGboardVO vo,BGFileVO vo1,MultipartFile[] file) throws Exception {
		log.info(vo+"");
		log.info(file[0].getOriginalFilename()+"");
		vo1.setBOARD_IDX(service.getBoardNum());
		ModelAndView mav = new ModelAndView("redirect:/battlegrounds/BGboardlist");
		service.BGboardwrite(vo);
		
		if(!(file[0].getOriginalFilename()).equals("")) {
			service.insertFile(vo1,file);
		}
		
		return mav;
	
		
		
	
	
		
	}
	
	
	
	@RequestMapping(value="/battlegrounds/BGboardlist", method=RequestMethod.POST)
	public void postBG(Model model,HttpSession session,
			Criteria cri,@RequestParam("searchName") String searchName) throws Exception {
		
		log.info("battlegrounds페이지 검색" );
		
		List<BGboardVO> BGboardList =  service.BGSearchList(cri);
		model.addAttribute("BGlist", BGboardList );
	
	}
	
	//value값에는 form태그의 action경로를 적어준다. method는 form태그와 똑같이 해준다. 
	//model객체는 jsp페이지로 data를 전달해준다. @RequestParam은 jsp에서 값을 받아 사용할 수 있게 해준다. 
	//HttpSession은 페이지내의 session정보를 저장해준다. (ex.login)
	@RequestMapping(value="/battlegrounds/BGread", method=RequestMethod.GET)
	public void getBGContent(Model model,HttpSession session,
			@RequestParam("num") int num) {
		
		log.info("BGread페이지로 이동 ");
		
		service.updateBGBoardCount(num);
		BGboardVO BGread = service.getBGContent(num);
		model.addAttribute("BGboard", BGread);
		
		List<Map<String,Object>> fileList=service.selectFileList(num);
		model.addAttribute("file", fileList);
	}
	
	@RequestMapping(value="/battlegrounds/BGmodify", method=RequestMethod.GET)
	public void getBGmodify(Model model,HttpSession session,
			@RequestParam("num") int num) {
		
		log.info("BGmodify페이지로 이동 ");
		
		BGboardVO BGread = service.getBGContent(num);
		model.addAttribute("BGboard", BGread);
	}
	
	
	@RequestMapping(value="/battlegrounds/BGmodify",method=RequestMethod.POST)
	public String postBGmodify(Model model,HttpSession session,
			@RequestParam("num") int num,BGboardVO vo) {
		
		log.info("BGmodify 글쓰기 수정하기 ");
		
		
		service.getBGmodify(vo);
		
		return "redirect:/battlegrounds/BGboardlist";
	
	}
	
	@RequestMapping(value="/battlegrounds/BGdelete",method=RequestMethod.GET)
	public String postBGdelete(@RequestParam("num") int num) {
		
		log.info("BGmodify 글쓰기 삭제하기");
		
		
		service.getBGdelete(num);
		
		return "redirect:/battlegrounds/BGboardlist";
	}

}
