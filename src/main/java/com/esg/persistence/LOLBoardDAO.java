package com.esg.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.esg.domain.LOLBoardVO;
import com.esg.domain.LOLCriteria;
import com.esg.domain.LOLReplyVO;

public interface LOLBoardDAO {

	List<LOLBoardVO> getBoardList(LOLCriteria cri);

	void insertBoard(LOLBoardVO vo);

	void updateBoardCnt(int num);

	LOLBoardVO getBoardContent(int num);
	
	void update(LOLBoardVO vo);

	void delete(int num);

	void insertFile(Map<String, Object> map);

	List<Map<String, Object>> selectFileList(int num);

	int countBoardList();

	List<LOLReplyVO> readReply(int num);

}
