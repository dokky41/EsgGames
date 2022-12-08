package com.esg.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.esg.domain.LOABoardVO;
import com.esg.domain.LOASearchCriteria;

public interface LOABoardService {
	//湲� 紐⑸줉
	List<LOABoardVO> getBoardList(LOASearchCriteria cri);
	//湲� �벐湲�+�뙆�씪�뾽濡쒕뱶
	void insertBoard(LOABoardVO vo, MultipartFile[] file)throws Exception;
	//議고쉶�닔 利앷�
	void updateBoardCount(int num);
	//湲� �젙蹂� 遺덈윭�삤湲�
	LOABoardVO readBoard(int num);
	//湲� �닔�젙
	void update(LOABoardVO vo);
	//湲� �궘�젣
	void deleteBoard(int num);
	//�뙆�씪 �젙蹂� 遺덈윭�삤湲�
	List<Map<String, Object>> selectFileList(int num);
	//珥앷갗�닔
	int countBoardListTotal(LOASearchCriteria cri);
	//�뙆�씪�씠 �뾾�쓣�븣 湲� �벐湲�
	void insertBoard(LOABoardVO vo);
	void recommend(int num);
}
