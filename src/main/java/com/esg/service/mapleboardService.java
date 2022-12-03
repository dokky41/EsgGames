package com.esg.service;

import java.util.List;

import javax.activation.CommandMap;

import org.springframework.web.multipart.MultipartFile;

import com.esg.domain.Criteria;
import com.esg.domain.mapleFileVO;
import com.esg.domain.mapleboardVO;

public interface mapleboardService {

	void mapleboardwrite(mapleboardVO vo);

	List<mapleboardVO> mapleboardlist(Criteria cri);

	//글 여러개 
	List<mapleboardVO> mapleSearchList(Criteria cri);

	void getmaplemodify(mapleboardVO vo);


	//글 하나 
	//return형식 중간부분 메소드 이름 (인자값 또는 매개변수 )
	mapleboardVO getmapleContent(int num);

	void getmapledelete(int num);

	//글 전체 개수 
	int totalCnt();

	void updatemapleBoardCount(int num);

	void insertFile(mapleFileVO vo1, MultipartFile[] file) throws Exception;

	int getBoardNum();

	



	

	

}
