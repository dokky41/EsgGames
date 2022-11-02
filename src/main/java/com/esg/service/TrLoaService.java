package com.esg.service;

import java.util.List;

import org.json.simple.JSONArray;

import com.esg.domain.trLoaVO;

public interface TrLoaService {
	
	//로아 최신정보 크롤링
	JSONArray getLoaNews();

	//로아 거래 글쓰기 동작
	void trLoaboardCreate(trLoaVO vo);

	//로아 글목록 불러오기
	List<trLoaVO> trLoaBoardList();

}
