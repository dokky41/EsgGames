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
import com.esg.domain.trLoaVO;
import com.esg.persistence.TrLoaDAO;

@Service
public class TrLoaServiceImpl implements TrLoaService{

	
	private static final Logger log = LoggerFactory.getLogger(TrLoaServiceImpl.class);

	@Inject
	TrLoaDAO dao;
	
	@Override
	public JSONArray getLoaNews() {
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
		Elements RoaNews = doc.select(".list.list--default .list__subject"); // 로아최신공지
		Elements RoaLink = doc.select(".list.list--default a"); // 로아최신공지

		// JSON 형태로 로아 정보 저장
		JSONArray RoaNewsList = new JSONArray();

		for (int i = 3; i < 8; i++) {
			// JSONObject에 키:값 형태로 데이터 저장
			JSONObject obj = new JSONObject();

			obj.put("RoaNews", RoaNews.get(i).text());
			obj.put("RoaLink", RoaLink.get(i).attr("href"));

			// RoaNews에 생성한 JSONObject 추가
//				log.info(obj+"");
			RoaNewsList.add(obj);
		}
//		System.out.println(" roomList : " + roomList);

		return RoaNewsList;
	}

	//로아 거래 글쓰기
	@Override
	public void trLoaboardCreate(trLoaVO vo) {

		dao.trLoaboardCreate(vo);

		
	}

	//로아 거래글 목록 불러오기
	@Override
	public List<trLoaVO> trLoaBoardList(Criteria cri) {
		
		return dao.trLoaBoardList(cri);
		
	}
	
	@Override
	public int totalCnt() {
		return dao.getTotalCnt();
	}

	@Override
	public List<trLoaVO> trLoaSearchList(Criteria cri) {
		return dao.trLoaSearchList(cri);
	}

	@Override
	public trLoaVO getTrLoaContent(int num) {
		return dao.getTrLoaContent(num);
	}

	@Override
	public int totalCnt2(String searchName) {
		// TODO Auto-generated method stub
		return dao.getTotalCnt2(searchName);
	}
}
