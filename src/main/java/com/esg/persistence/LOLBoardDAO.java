package com.esg.persistence;

import java.util.List;
import java.util.Map;

import com.esg.domain.LOLBoardVO;

public interface LOLBoardDAO {

	List<LOLBoardVO> getBoardList();

	void insertBoard(LOLBoardVO vo);

	void updateBoardCnt(int num);

	LOLBoardVO getBoardContent(int num);
	
	void update(LOLBoardVO vo);

	void delete(int num);


}
