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
import com.esg.domain.trLoaVO;
import com.esg.domain.trLolVO;
import com.esg.domain.trMailVO;
import com.esg.domain.trMpVO;
import com.esg.persistence.TrLoaDAO;
import com.esg.persistence.TrLolDAO;
import com.esg.persistence.TrMpDAO;

@Service
public class TrMpServiceImpl implements TrMpService{

	
	private static final Logger log = LoggerFactory.getLogger(TrMpServiceImpl.class);

	@Inject
	TrMpDAO dao;
	
	@Override
	public JSONArray getMpNews() {
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
		Elements mpNews = doc.select(".list.list--default .list__subject"); // 로아최신공지
		Elements mpLink = doc.select(".list.list--default a"); // 로아최신공지

		// JSON 형태로 로아 정보 저장
		JSONArray mpNewsList = new JSONArray();

		for (int i = 3; i < 8; i++) {
			// JSONObject에 키:값 형태로 데이터 저장
			JSONObject obj = new JSONObject();

			obj.put("mpNews", mpNews.get(i).text());
			obj.put("mpLink", mpLink.get(i).attr("href"));

			// RoaNews에 생성한 JSONObject 추가
//				log.info(obj+"");
			mpNewsList.add(obj);
		}
//		System.out.println(" roomList : " + roomList);

		return mpNewsList;
	}

	//로아 거래 글쓰기
	@Override
	public void trMpboardCreate(trMpVO vo) {

		dao.trMpboardCreate(vo);

		
	}

	//로아 거래글 목록 불러오기
	@Override
	public List<trMpVO> trMpBoardList(Criteria cri) {
		
		return dao.trMpBoardList(cri);
		
	}
	
	@Override
	public int totalCnt() {
		return dao.getTotalCnt();
	}

	@Override
	public List<trMpVO> trMpSearchList(Criteria cri) {
		return dao.trMpSearchList(cri);
	}

	@Override
	public trMpVO getTrMpContent(int num) {
		return dao.getTrMpContent(num);
	}

	@Override
	public int totalCnt2(String searchName) {
		// TODO Auto-generated method stub
		return dao.getTotalCnt2(searchName);
	}

	@Override
	public void getTrMpModify(trMpVO vo) {
		
		dao.getTrMpModify(vo);
		
	}

	@Override
	public void getTrMpDelete(int num) {
		dao.getTrMpDelete(num);
	}

	
	@Override
	public void updateTrBoardCount(int num) {
		dao.updateTrBoardCount(num);
		
	}

	@Override
	public List<trMpVO> trMpBoardSelList(Criteria cri) {
		return dao.trMpBoardSelList(cri);
	}

	@Override
	public List<trMpVO> trMpBoardPriList(Criteria cri) {
		return dao.trMpBoardPriList(cri);
	}

	@Override
	public List<trMpVO> trMpBoardPri2List(Criteria cri) {
		return dao.trMpBoardPriList2(cri);
	}

	@Override
	public void trRequestMail(trMailVO vo) {
		dao.trRequestMail(vo);
	}


	






	


	
	
	
	
}
