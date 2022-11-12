package com.esg.service;

import java.util.List;

import com.esg.domain.Criteria;
import com.esg.domain.mapleboardVO;

public interface mapleboardService {

	void mapleboardwrite(mapleboardVO vo);

	List<mapleboardVO> mapleboardlist();

	//글 여러개 
	List<mapleboardVO> mapleSearchList(Criteria cri);

	void getmaplemodify(mapleboardVO vo);


	//글 하나 
	//return형식 중간부분 메소드 이름 (인자값 또는 매개변수 )
	mapleboardVO getmapleContent(int num);

}
