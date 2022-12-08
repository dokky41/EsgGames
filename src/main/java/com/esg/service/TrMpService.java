package com.esg.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.springframework.web.multipart.MultipartFile;

import com.esg.domain.Criteria;
import com.esg.domain.MemberVO;
import com.esg.domain.trLoaVO;
import com.esg.domain.trLolVO;
import com.esg.domain.trMailVO;
import com.esg.domain.trMpVO;

public interface TrMpService {
	
	//로아 최신정보 크롤링
	JSONArray getMpNews();

	//로아 거래 글쓰기 동작
	void trMpboardCreate(trMpVO vo);

	//로아 글목록 불러오기
	List<trMpVO> trMpBoardList(Criteria cri);

	//글 전체수
    int totalCnt();

	//글 검색
	List<trMpVO> trMpSearchList(Criteria cri);

	//글 내용보기
	trMpVO getTrMpContent(int num);
	
	//검색결과 수
	int totalCnt2(String searchName);

	//글 수정
	void getTrMpModify(trMpVO vo);

	//글삭제
	void getTrMpDelete(int num);

	//조회수증가
	void updateTrBoardCount(int num);

	//조회수순으로 글불러오기
	List<trMpVO> trMpBoardSelList(Criteria cri);

	//낮은가격순으로 글 불러오기
	List<trMpVO> trMpBoardPriList(Criteria cri);

	//높은가격순으로 글 불러오기
	List<trMpVO> trMpBoardPri2List(Criteria cri);

	//거래신청
	void trRequestMail(trMailVO vo);



}
