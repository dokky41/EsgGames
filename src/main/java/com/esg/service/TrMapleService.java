package com.esg.service;

import java.util.List;

import com.esg.domain.Criteria;
import com.esg.domain.trMapleVO;

public interface TrMapleService {
	
	void trMapleboardCreate(trMapleVO vo); //글 작성


	List<trMapleVO> trMapleSearchList(Criteria cri); //목록검색


	int TotalCnt(); //글갯수


	List<trMapleVO> trMapleBoardList(Criteria cri); //글목록
	
	

	

}