package com.esg.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.esg.domain.Criteria;
import com.esg.domain.MemberVO;
import com.esg.domain.PageMaker;
import com.esg.domain.trLolVO;
import com.esg.domain.trMailVO;
import com.esg.domain.trMpVO;
import com.esg.service.TrLolService;
import com.esg.service.TrMpService;

@Controller
@RequestMapping("/mpTrBoard/*")
public class mpTrController {

	private static final Logger log = LoggerFactory.getLogger(mpTrController.class);

	@Inject
	private TrMpService service;

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public void gettest() {

	}

	@RequestMapping(value = "/trContent", method = RequestMethod.GET)
	public void gettrLolContent(Model model, HttpSession session,
			@RequestParam("num") int num, Criteria cri,@RequestParam("page") int page) {

		log.info("trContent 거래상세페이지 이동");

		// 로아 최신뉴스 크롤링
		JSONArray mpNews = service.getMpNews();

		model.addAttribute("mpNews", mpNews);


		// 조회수 증가
		service.updateTrBoardCount(num);

		// 해당글내용 불러오기
		log.info(service.getTrMpContent(num)+"");
		session.setAttribute("trMp", service.getTrMpContent(num));
		// 해당글내용 불러오기

		
		// 하단 페이징처리 정보 전달
		model.addAttribute("pageCnt", page);
	}

	@RequestMapping(value = "/trList", method = RequestMethod.GET)
	public void gettrLol(Model model, HttpSession session, Criteria cri, 
			@RequestParam("sort") String sort) throws Exception {

		log.info("mp 거래페이지 이동");

		// 로아 최신뉴스 크롤링
		JSONArray mpNews = service.getMpNews();

		model.addAttribute("mpNews", mpNews);

		log.info(mpNews+"");
		// 로아 최신뉴스 크롤링
		List<trMpVO> trMpList = null;
		// 로아 거래글 목록 불러오기
		if (sort.equals("def")) {
			trMpList = service.trMpBoardList(cri);
		} else if (sort.equals("sel")) {
			trMpList = service.trMpBoardSelList(cri);
		} else if (sort.equals("pri")) {
			trMpList = service.trMpBoardPriList(cri);
		}else if (sort.equals("pri2")) {
			trMpList = service.trMpBoardPri2List(cri);
		}
		// 로아 거래글 목록 불러오기

		log.info("어어" + trMpList + "");

		model.addAttribute("listSize", service.totalCnt());

		// 로아글목록 저장
		model.addAttribute("trMpList", trMpList);
	
		// 로아글목록 저장

		// 하단 페이징처리 정보 전달
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.totalCnt());

		model.addAttribute("pm", pageMaker);

	}

	@RequestMapping(value = "/trList", method = RequestMethod.POST)
	public void posttrLol(Model model, HttpSession session, Criteria cri,
			@RequestParam("searchName") String searchName, 
			@RequestParam("sort") String sort) throws Exception {

		log.info("Lol 거래페이지 검색");

		// 로아 최신뉴스 크롤링
		JSONArray mpNews = service.getMpNews();

		model.addAttribute("mpNews", mpNews);


//		log.info(LoaNews+"");
		// 로아 최신뉴스 크롤링
		
		List<trMpVO> trMpList = null;
		// 로아 거래글 목록 불러오기
			trMpList = service.trMpSearchList(cri);
		// 로아 거래글 목록 불러오기

		log.info("ok:" + trMpList + "");
		// 거래글수
		model.addAttribute("listSize", service.totalCnt2(searchName));
		// 거래글수

		// 로아글목록 저장
		model.addAttribute("trMpList", trMpList);
		// 로아글목록 저장

		// 하단 페이징처리 정보 전달
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.totalCnt2(searchName));

		log.info("페이지메이커"+pageMaker);
		model.addAttribute("pm", pageMaker);

		
	}

	@RequestMapping(value = "/trWrite", method = RequestMethod.GET)
	public void gettrMpWrite(Model model, HttpSession session) {

		log.info("Mp 거래작성페이지로 이동");

		// 로아 최신뉴스 크롤링
		JSONArray MpNews = service.getMpNews();

		model.addAttribute("MpNews", MpNews);

		log.info(MpNews + "");
		// 로아 최신뉴스 크롤링

	}
	
	int WRcount=1;
	@RequestMapping(value = "/trWrite", method = RequestMethod.POST)
	public String gettrMpWrite(ArrayList<MultipartFile> files, trMpVO vo, HttpServletRequest req,
			@RequestParam("userid") String userid) {

		log.info("Mp 거래작성완료");

		// 사진저장부분
		files.forEach(file -> {
			UUID uuid = UUID.randomUUID();
			String newName = uuid.toString();
			log.info("---------------------");
			log.info("name : " + uuid);
			log.info("size : " + file.getSize());
			File saveFile=null;
			if(WRcount==1) {
				vo.setFile1("C:\\test\\file\\" + newName);
				saveFile = new File("C:\\test\\file\\", newName);
				vo.setFile1(newName);
			}else if(WRcount==2) {
				vo.setFile2("C:\\test\\file\\" + newName);
				saveFile = new File("C:\\test\\file\\", newName);
				vo.setFile2(newName);
			}else if(WRcount==3) {
				vo.setFile3("C:\\test\\file\\" + newName);
				saveFile = new File("C:\\test\\file\\", newName);
				vo.setFile3(newName);
			}else if(WRcount==4) {
				vo.setFile4("C:\\test\\file\\" + newName);
				saveFile = new File("C:\\test\\file\\", newName);
				vo.setFile4(newName);
			}
			
			try {
				file.transferTo(saveFile);
				
			} catch (Exception e) {
				log.info(e.getMessage());
			}
			WRcount++;
		});
		// 사진저장부분
		vo.setUserid(userid); // 아이디 저장
		vo.setIp(req.getRemoteAddr()); // 작성 아이피 저장

		log.info("저장 후 vo : " + vo);

		// 글 작성 서비스동작
		service.trMpboardCreate(vo);

		WRcount=1;
		return "redirect:/mpTrBoard/trList?sort=def&page=1";
	}
	@RequestMapping(value = "/trMpModify", method = RequestMethod.GET)
	public void gettrMpModify(Model model, HttpSession session,
			@RequestParam("num") int num) {

		log.info("trMp 거래글 수정페이지로 이동");

		// 로아 최신뉴스 크롤링
		JSONArray mpNews = service.getMpNews();

		model.addAttribute("mpNews", mpNews);

		log.info(mpNews + "");
		// 로아 최신뉴스 크롤링

		// 해당글내용 불러오기
		log.info(service.getTrMpContent(num) + "");
		session.setAttribute("trLoa", service.getTrMpContent(num));
		// 해당글내용 불러오기

	}

	@RequestMapping(value = "/trMpModify", method = RequestMethod.POST)
	public String posttrMpModify(Model model, HttpSession session, 
			@RequestParam("num") int num, trMpVO vo,ArrayList<MultipartFile> files) {

		log.info("trMpModify 거래글 수정하기");

		// 사진저장부분
				files.forEach(file -> {
					UUID uuid = UUID.randomUUID();
					String newName = uuid.toString();
					log.info("---------------------");
					log.info("name : " + uuid);
					log.info("size : " + file.getSize());
					File saveFile=null;
					if(WRcount==1) {
						vo.setFile1("C:\\test\\file\\" + newName);
						saveFile = new File("C:\\test\\file\\", newName);
						vo.setFile1(newName);
					}else if(WRcount==2) {
						vo.setFile2("C:\\test\\file\\" + newName);
						saveFile = new File("C:\\test\\file\\", newName);
						vo.setFile2(newName);
					}else if(WRcount==3) {
						vo.setFile3("C:\\test\\file\\" + newName);
						saveFile = new File("C:\\test\\file\\", newName);
						vo.setFile3(newName);
					}else if(WRcount==4) {
						vo.setFile4("C:\\test\\file\\" + newName);
						saveFile = new File("C:\\test\\file\\", newName);
						vo.setFile4(newName);
					}
					
					try {
						file.transferTo(saveFile);
						
					} catch (Exception e) {
						log.info(e.getMessage());
					}
					WRcount++;
				});
				// 사진저장부분
		// 해당글내용 수정
		service.getTrMpModify(vo);
		// 해당글내용 수정

		return "redirect:/mpTrBoard/trMpContent?num=" + num;
	}

	@RequestMapping(value = "/trMpdelete", method = RequestMethod.POST)
	public String posttrMpDelete(@RequestParam("num") int num) {

		log.info("trMpModify 거래글 삭제하기");

		
		
		// 해당글내용 삭제
		service.getTrMpDelete(num);
		// 해당글내용 삭제

		return "redirect:/mpTrBoard/trList?sort=def";
	}
	
	@RequestMapping(value = "/trSendRequest", method = RequestMethod.POST)
	public String trSendRequest(trMailVO vo) {
		
		log.info("trSendRequest 거래요청하기");
		
		//거래요청하기
		service.trRequestMail(vo);
		//거래요청하기

		return "redirect:/mpTrBoard/trList?sort=def";
	}
	
	
}
