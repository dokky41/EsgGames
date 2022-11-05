package com.esg.persistence;

import java.util.List;

import com.esg.domain.Criteria;
import com.esg.domain.trLoaVO;

public interface TrLoaDAO {

	//로아 거래글 업로드
	void trLoaboardCreate(trLoaVO vo);

	//로아 거래글 목록 불러오기
	List<trLoaVO> trLoaBoardList(Criteria cri);

	//글 전체 개수 조회
	int getTotalCnt();

	//로아 거래글 목록 검색
	List<trLoaVO> trLoaSearchList(Criteria cri);

	//로아 거래글 상세내용
	trLoaVO getTrLoaContent(int num);

	//검색 해당글 갯수
	int getTotalCnt2(String searchName);

	//해당글 수정
	void getTrLoaModify(trLoaVO vo);

	//해당글 삭제
	void getTrLoaDelete(int num);

}
