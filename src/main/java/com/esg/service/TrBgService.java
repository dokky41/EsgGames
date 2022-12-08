package com.esg.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.springframework.web.multipart.MultipartFile;

import com.esg.domain.Criteria;
import com.esg.domain.MemberVO;
import com.esg.domain.trBgVO;
import com.esg.domain.trLoaVO;
import com.esg.domain.trLolVO;
import com.esg.domain.trMailVO;
import com.esg.domain.trMpVO;

public interface TrBgService {
	
	//로아 최신정보 크롤링
	JSONArray getBgNews();

	//로아 거래 글쓰기 동작
	void trBgboardCreate(trBgVO vo);

	//로아 글목록 불러오기
	List<trBgVO> trBgBoardList(Criteria cri);

	//글 전체수
    int totalCnt();

	//글 검색
	List<trBgVO> trBgSearchList(Criteria cri);

	//글 내용보기
	trBgVO getTrBgContent(int num);
	
	//검색결과 수
	int totalCnt2(String searchName);

	//글 수정
	void getTrBgModify(trBgVO vo);

	//글삭제
	void getTrBgDelete(int num);

	//조회수증가
	void updateTrBoardCount(int num);

	//조회수순으로 글불러오기
	List<trBgVO> trBgBoardSelList(Criteria cri);

	//낮은가격순으로 글 불러오기
	List<trBgVO> trBgBoardPriList(Criteria cri);

	//높은가격순으로 글 불러오기
	List<trBgVO> trBgBoardPri2List(Criteria cri);

	//거래신청
	void trRequestMail(trMailVO vo);



}
