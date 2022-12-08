package com.esg.persistence;

import java.util.List;

import com.esg.domain.Criteria;
import com.esg.domain.MemberVO;
import com.esg.domain.trLoaVO;
import com.esg.domain.trMailVO;
import com.esg.domain.trMpVO;

public interface TrMpDAO {

	//로아 거래글 업로드
	void trMpboardCreate(trMpVO vo);

	//로아 거래글 목록 불러오기
	List<trMpVO> trMpBoardList(Criteria cri);

	//글 전체 개수 조회
	int getTotalCnt();

	//로아 거래글 목록 검색
	List<trMpVO> trMpSearchList(Criteria cri);

	//로아 거래글 상세내용
	trMpVO getTrMpContent(int num);

	//검색 해당글 갯수
	int getTotalCnt2(String searchName);

	//해당글 수정
	void getTrMpModify(trMpVO vo);

	//해당글 삭제
	void getTrMpDelete(int num);

	//조회수 증가
	void updateTrBoardCount(int num);

	//조회수순으로 글 불러오기
	List<trMpVO> trMpBoardSelList(Criteria cri);

	//낮은가격순으로 글 불러오기
	List<trMpVO> trMpBoardPriList(Criteria cri);

	//높은가격순으로 글 불러오기
	List<trMpVO> trMpBoardPriList2(Criteria cri);

	//거래글작성
	void trRequestMail(trMailVO vo);



	

}
