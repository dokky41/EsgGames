package com.esg.service;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.esg.domain.Criteria;
import com.esg.domain.MemberVO;
import com.esg.domain.trBgVO;
import com.esg.domain.trLoaVO;
import com.esg.domain.trLolVO;
import com.esg.domain.trMailVO;
import com.esg.domain.trMpVO;
import com.esg.persistence.TrBgDAO;
import com.esg.persistence.TrLoaDAO;
import com.esg.persistence.TrLolDAO;
import com.esg.persistence.TrMpDAO;

@Service
public class TrBgServiceImpl implements TrBgService{

	
	private static final Logger log = LoggerFactory.getLogger(TrBgServiceImpl.class);

	@Inject
	TrBgDAO dao;
	
	@Override
	public JSONArray getBgNews() {
//		log.info("service : 숙소목록불러오기");

		// Jsoup를 이용해서 크롤링 - 여기어때
		String url = "https://lostark.game.onstove.com/News/Notice/List?noticetype=notice";

		Document doc = null; // Document에 페이지의 전체 소스가 저장됨

		try {
			doc = Jsoup.connect(url).get();

		} catch (IOException e) {
			e.printStackTrace();
		}

		// select를 이용하여 원하는 태그를 선택
		Elements bgNews = doc.select(".list.list--default .list__subject"); // 로아최신공지
		Elements bgLink = doc.select(".list.list--default a"); // 로아최신공지

		// JSON 형태로 로아 정보 저장
		JSONArray bgNewsList = new JSONArray();

		for (int i = 3; i < 8; i++) {
			// JSONObject에 키:값 형태로 데이터 저장
			JSONObject obj = new JSONObject();

			obj.put("bgNews", bgNews.get(i).text());
			obj.put("bgLink", bgLink.get(i).attr("href"));

			// RoaNews에 생성한 JSONObject 추가
//				log.info(obj+"");
			bgNewsList.add(obj);
		}
//		System.out.println(" roomList : " + roomList);

		return bgNewsList;
	}

	//로아 거래 글쓰기
	@Override
	public void trBgboardCreate(trBgVO vo) {

		dao.trBgboardCreate(vo);

		
	}

	//로아 거래글 목록 불러오기
	@Override
	public List<trBgVO> trBgBoardList(Criteria cri) {
		
		return dao.trBgBoardList(cri);
		
	}
	
	@Override
	public int totalCnt() {
		return dao.getTotalCnt();
	}

	@Override
	public List<trBgVO> trBgSearchList(Criteria cri) {
		return dao.trBgSearchList(cri);
	}

	@Override
	public trBgVO getTrBgContent(int num) {
		return dao.getTrBgContent(num);
	}

	@Override
	public int totalCnt2(String searchName) {
		// TODO Auto-generated method stub
		return dao.getTotalCnt2(searchName);
	}

	@Override
	public void getTrBgModify(trBgVO vo) {
		
		dao.getTrBgModify(vo);
		
	}

	@Override
	public void getTrBgDelete(int num) {
		dao.getTrBgDelete(num);
	}

	
	@Override
	public void updateTrBoardCount(int num) {
		dao.updateTrBoardCount(num);
		
	}

	@Override
	public List<trBgVO> trBgBoardSelList(Criteria cri) {
		return dao.trBgBoardSelList(cri);
	}

	@Override
	public List<trBgVO> trBgBoardPriList(Criteria cri) {
		return dao.trBgBoardPriList(cri);
	}

	@Override
	public List<trBgVO> trBgBoardPri2List(Criteria cri) {
		return dao.trBgBoardPriList2(cri);
	}

	@Override
	public void trRequestMail(trMailVO vo) {
		dao.trRequestMail(vo);
	}


	






	


	
	
	
	
}
