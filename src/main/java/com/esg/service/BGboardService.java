package com.esg.service;

import java.util.List;
import java.util.Map;


import org.springframework.web.multipart.MultipartFile;

import com.esg.domain.BGFileVO;
import com.esg.domain.BGboardVO;
import com.esg.domain.Criteria;

public interface BGboardService {
	
	void BGboardwrite(BGboardVO vo);

	List<BGboardVO> BGboardlist(Criteria cri);

	//글 여러개 
	List<BGboardVO> BGSearchList(Criteria cri);

	void getBGmodify(BGboardVO vo);


	//글 하나 
	//return형식 중간부분 메소드 이름 (인자값 또는 매개변수 )
	BGboardVO getBGContent(int num);

	void getBGdelete(int num);

	//글 전체 개수 
	int totalCnt();

	void updateBGBoardCount(int num);

	void insertFile(BGFileVO vo1, MultipartFile[] file) throws Exception;

	int getBoardNum();

	List<Map<String, Object>> selectFileList(int num);

}
