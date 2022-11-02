package com.esg.persistence;

import java.util.List;

import com.esg.domain.trLoaVO;

public interface TrLoaDAO {

	//로아 거래글 업로드
	void trLoaboardCreate(trLoaVO vo);

	//로아 거래글 목록 불러오기
	List<trLoaVO> trLoaBoardList();

}
