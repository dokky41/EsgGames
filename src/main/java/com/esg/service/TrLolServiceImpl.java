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
import com.esg.persistence.TrLoaDAO;
import com.esg.persistence.TrLolDAO;

@Service
public class TrLolServiceImpl implements TrLolService{

	
	private static final Logger log = LoggerFactory.getLogger(TrLolServiceImpl.class);

	@Inject
	TrLolDAO dao;
	
	@Override
	public JSONArray getLolNews() {
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
		Elements lolNews = doc.select(".list.list--default .list__subject"); // 로아최신공지
		Elements lolLink = doc.select(".list.list--default a"); // 로아최신공지

		// JSON 형태로 로아 정보 저장
		JSONArray LolNewsList = new JSONArray();

		for (int i = 3; i < 8; i++) {
			// JSONObject에 키:값 형태로 데이터 저장
			JSONObject obj = new JSONObject();

			obj.put("lolNews", lolNews.get(i).text());
			obj.put("lolLink", lolLink.get(i).attr("href"));

			// RoaNews에 생성한 JSONObject 추가
//				log.info(obj+"");
			LolNewsList.add(obj);
		}
//		System.out.println(" roomList : " + roomList);

		return LolNewsList;
	}

	//로아 거래 글쓰기
	@Override
	public void trLolboardCreate(trLolVO vo) {

		dao.trLolboardCreate(vo);

		
	}

	//로아 거래글 목록 불러오기
	@Override
	public List<trLolVO> trLolBoardList(Criteria cri) {
		
		return dao.trLolBoardList(cri);
		
	}
	
	@Override
	public int totalCnt() {
		return dao.getTotalCnt();
	}

	@Override
	public List<trLolVO> trLolSearchList(Criteria cri) {
		return dao.trLolSearchList(cri);
	}

	@Override
	public trLolVO getTrLolContent(int num) {
		return dao.getTrLolContent(num);
	}

	@Override
	public int totalCnt2(String searchName) {
		// TODO Auto-generated method stub
		return dao.getTotalCnt2(searchName);
	}

	@Override
	public void getTrLolModify(trLolVO vo) {
		
		dao.getTrLolModify(vo);
		
	}

	@Override
	public void getTrLolDelete(int num) {
		dao.getTrLolDelete(num);
	}

	
	@Override
	public void updateTrBoardCount(int num) {
		dao.updateTrBoardCount(num);
		
	}

	@Override
	public List<trLolVO> trLolBoardSelList(Criteria cri) {
		return dao.trLolBoardSelList(cri);
	}

	@Override
	public List<trLolVO> trLolBoardPriList(Criteria cri) {
		return dao.trLolBoardPriList(cri);
	}

	@Override
	public List<trLolVO> trLolBoardPri2List(Criteria cri) {
		return dao.trLolBoardPriList2(cri);
	}

	@Override
	public void trRequestMail(trMailVO vo) {
		dao.lolTrRequestMail(vo);
	}






	


	
	
	
	
}
