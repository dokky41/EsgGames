package com.esg.persistence;

import java.util.List;
import com.esg.domain.LOLBoardVO;

public interface LOLBoardDAO {

	List<LOLBoardVO> getBoardList();

	void insertBoard(LOLBoardVO vo);


}
