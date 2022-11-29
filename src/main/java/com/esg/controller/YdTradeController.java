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
import com.esg.domain.trLoaVO;
import com.esg.domain.trMailVO;
import com.esg.service.TrLoaService;

@Controller
@RequestMapping("/ydTrBoard/*")
public class YdTradeController {

	private static final Logger log = LoggerFactory.getLogger(YdTradeController.class);

	@Inject
	private TrLoaService service;

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public void gettest() {

	}

	@RequestMapping(value = "/trLoaContent", method = RequestMethod.GET)
	public void gettrLoaContent(Model model, HttpSession session,
			@RequestParam("num") int num, Criteria cri,@RequestParam("page") int page) {

		log.info("LostContent 거래상세페이지 이동");

		// 로아 최신뉴스 크롤링
		JSONArray LoaNews = service.getLoaNews();

		model.addAttribute("LoaNews", LoaNews);

//		log.info(LoaNews+"");
		// 로아 최신뉴스 크롤링

		// 조회수 증가
		service.updateTrBoardCount(num);

		// 해당글내용 불러오기
		log.info(service.getTrLoaContent(num)+"");
		session.setAttribute("trLoa", service.getTrLoaContent(num));
		// 해당글내용 불러오기

		
		// 하단 페이징처리 정보 전달
		model.addAttribute("pageCnt", page);
	}

	@RequestMapping(value = "/trLostArk", method = RequestMethod.GET)
	public void gettrLostArk(Model model, HttpSession session, Criteria cri, 
			@RequestParam("sort") String sort) throws Exception {

		log.info("LostArk 거래페이지 이동");

		// 로아 최신뉴스 크롤링
		JSONArray LoaNews = service.getLoaNews();

		model.addAttribute("LoaNews", LoaNews);

//		log.info(LoaNews+"");
		// 로아 최신뉴스 크롤링
		List<trLoaVO> trLoaList = null;
		// 로아 거래글 목록 불러오기
		if (sort.equals("def")) {
			trLoaList = service.trLoaBoardList(cri);
		} else if (sort.equals("sel")) {
			trLoaList = service.trLoaBoardSelList(cri);
		} else if (sort.equals("pri")) {
			trLoaList = service.trLoaBoardPriList(cri);
		}else if (sort.equals("pri2")) {
			trLoaList = service.trLoaBoardPri2List(cri);
		}
		// 로아 거래글 목록 불러오기

		log.info("어어" + trLoaList + "");

		model.addAttribute("listSize", service.totalCnt());

		// 로아글목록 저장
		model.addAttribute("trLoaList", trLoaList);
	
		// 로아글목록 저장

		// 하단 페이징처리 정보 전달
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.totalCnt());

		model.addAttribute("pm", pageMaker);

	}

	@RequestMapping(value = "/trLostArk", method = RequestMethod.POST)
	public void posttrLostArk(Model model, HttpSession session, Criteria cri,
			@RequestParam("searchName") String searchName, 
			@RequestParam("sort") String sort) throws Exception {

		log.info("LostArk 거래페이지 검색");

		// 로아 최신뉴스 크롤링
		JSONArray LoaNews = service.getLoaNews();

		model.addAttribute("LoaNews", LoaNews);


//		log.info(LoaNews+"");
		// 로아 최신뉴스 크롤링
		
		List<trLoaVO> trLoaList = null;
		// 로아 거래글 목록 불러오기
			trLoaList = service.trLoaSearchList(cri);
		// 로아 거래글 목록 불러오기

		log.info("ok:" + trLoaList + "");
		// 거래글수
		model.addAttribute("listSize", service.totalCnt2(searchName));
		// 거래글수

		// 로아글목록 저장
		model.addAttribute("trLoaList", trLoaList);
		// 로아글목록 저장

		// 하단 페이징처리 정보 전달
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.totalCnt2(searchName));

		model.addAttribute("pm", pageMaker);

		
	}

	@RequestMapping(value = "/trLostWrite", method = RequestMethod.GET)
	public void gettrLostWrite(Model model, HttpSession session) {

		log.info("LostArk 거래작성페이지로 이동");

		// 로아 최신뉴스 크롤링
		JSONArray LoaNews = service.getLoaNews();

		model.addAttribute("LoaNews", LoaNews);

		log.info(LoaNews + "");
		// 로아 최신뉴스 크롤링

	}
	
	int WRcount=1;
	@RequestMapping(value = "/trLoaWrite", method = RequestMethod.POST)
	public String gettrLostWrite(ArrayList<MultipartFile> files, trLoaVO vo, HttpServletRequest req,
			@RequestParam("userid") String userid) {

		log.info("LostArk 거래작성완료");

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
		service.trLoaboardCreate(vo);

		WRcount=1;
		return "redirect:/ydTrBoard/trLostArk?sort=def&page=1";
	}
	@RequestMapping(value = "/trLostModify", method = RequestMethod.GET)
	public void gettrLostModify(Model model, HttpSession session,
			@RequestParam("num") int num) {

		log.info("trLostModify 거래글 수정페이지로 이동");

		// 로아 최신뉴스 크롤링
		JSONArray LoaNews = service.getLoaNews();

		model.addAttribute("LoaNews", LoaNews);

		log.info(LoaNews + "");
		// 로아 최신뉴스 크롤링

		// 해당글내용 불러오기
		log.info(service.getTrLoaContent(num) + "");
		session.setAttribute("trLoa", service.getTrLoaContent(num));
		// 해당글내용 불러오기

	}

	@RequestMapping(value = "/trLostModify", method = RequestMethod.POST)
	public String posttrLostModify(Model model, HttpSession session, 
			@RequestParam("num") int num, trLoaVO vo,ArrayList<MultipartFile> files) {

		log.info("trLostModify 거래글 수정하기");

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
		service.getTrLoaModify(vo);
		// 해당글내용 수정

		return "redirect:/ydTrBoard/trLoaContent?num=" + num;
	}

	@RequestMapping(value = "/trLoadelete", method = RequestMethod.POST)
	public String posttrLoaDelete(@RequestParam("num") int num) {

		log.info("trLostModify 거래글 삭제하기");

		
		
		// 해당글내용 삭제
		service.getTrLoaDelete(num);
		// 해당글내용 삭제

		return "redirect:/ydTrBoard/trLostArk?sort=def";
	}
	
	@RequestMapping(value = "/trSendRequest", method = RequestMethod.POST)
	public String trSendRequest(trMailVO vo) {
		
		log.info("trSendRequest 거래요청하기");
		
		//거래요청하기
		service.trRequestMail(vo);
		//거래요청하기

		return "redirect:/ydTrBoard/trLostArk?sort=def";
	}
	
	
}
