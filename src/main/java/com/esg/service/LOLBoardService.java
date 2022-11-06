package com.esg.service;

import java.util.List;
import java.util.Map;

import com.esg.domain.LOLBoardVO;

public interface LOLBoardService {
	//글 목록
	List<LOLBoardVO> getBoardList();
	//글 쓰기
	void insertBoard(LOLBoardVO vo);
	//조회수 증가
	void updateBoardCount(int num);
	//글 정보 불러오기
	LOLBoardVO readBoard(int num);
	//글 수정
	void update(LOLBoardVO vo);
	//글 삭제
	void deleteBoard(int num);



}
