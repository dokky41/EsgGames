package com.esg.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.esg.domain.LOLBoardVO;

public interface LOLBoardService {
	//글 목록
	List<LOLBoardVO> getBoardList();
	//글 쓰기+파일업로드
	void insertBoard(LOLBoardVO vo, MultipartFile[] file)throws Exception;
	//조회수 증가
	void updateBoardCount(int num);
	//글 정보 불러오기
	LOLBoardVO readBoard(int num);
	//글 수정
	void update(LOLBoardVO vo);
	//글 삭제
	void deleteBoard(int num);
}

