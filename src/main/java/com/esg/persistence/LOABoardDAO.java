package com.esg.persistence;

import java.util.List;
import java.util.Map;

import com.esg.domain.LOABoardVO;
import com.esg.domain.LOASearchCriteria;

public interface LOABoardDAO {
	List<LOABoardVO> getBoardList(LOASearchCriteria cri);

	void insertBoard(LOABoardVO vo);

	void updateBoardCnt(int num);

	LOABoardVO getBoardContent(int num);
	
	void update(LOABoardVO vo);

	void delete(int num);

	void insertFile(Map<String, Object> map);

	List<Map<String, Object>> selectFileList(int num);

	int countBoardList(LOASearchCriteria cri);

	void recommend(int num);
}
