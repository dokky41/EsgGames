package com.esg.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.esg.domain.LOLBoardVO;
import com.esg.domain.LOLCriteria;
import com.esg.domain.LOLReplyVO;

public interface LOLBoardService {
	//ï¿½ï¿½ ï¿½ï¿½ï¿½
	List<LOLBoardVO> getBoardList(LOLCriteria cri);
	//ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½+ï¿½ï¿½ï¿½Ï¾ï¿½ï¿½Îµï¿½
	void insertBoard(LOLBoardVO vo, MultipartFile[] file)throws Exception;
	//ï¿½ï¿½È¸ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
	void updateBoardCount(int num);
	//ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½Ò·ï¿½ï¿½ï¿½ï¿½ï¿½
	LOLBoardVO readBoard(int num);
	//ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
	void update(LOLBoardVO vo);
	//ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
	void deleteBoard(int num);
	//ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½Ò·ï¿½ï¿½ï¿½ï¿½ï¿½
	List<Map<String, Object>> selectFileList(int num);
	//ÃÑ°¹¼ö
	int countBoardListTotal();
	//ÆÄÀÏÀÌ ¾øÀ»¶§ ±Û ¾²±â
	void insertBoard(LOLBoardVO vo);
	void recommend(int num);
}
