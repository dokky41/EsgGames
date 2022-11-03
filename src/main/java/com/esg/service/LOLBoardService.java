package com.esg.service;

import java.util.List;
import com.esg.domain.LOLBoardVO;

public interface LOLBoardService {

	List<LOLBoardVO> getBoardList();

	void insertBoard(LOLBoardVO vo);



}
