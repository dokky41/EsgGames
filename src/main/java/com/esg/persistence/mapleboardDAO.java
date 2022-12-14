package com.esg.persistence;

import java.util.List;
import java.util.Map;

import com.esg.domain.Criteria;
import com.esg.domain.mapleboardVO;

public interface mapleboardDAO {

	void mapleboardwrite(mapleboardVO vo);

	List<mapleboardVO> mapleboardlist(Criteria cri);

	List<mapleboardVO> mapleSearchList(Criteria cri);

	void getmaplemodify(mapleboardVO vo);


	mapleboardVO getmapleContent(int num);

	void getmapledelete(int num);

	//글 전체 개수 
	int totalCnt();

	void updatemapleBoardCount(int num);


	void insertFile(Map<String, Object> map);

	

	int getBoardNum();

	List<Map<String, Object>> selectFileList(int num);

	

	
	
	
	
	


	

}
