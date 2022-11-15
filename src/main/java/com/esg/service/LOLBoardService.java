package com.esg.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.esg.domain.LOLBoardVO;
import com.esg.domain.LOLCriteria;

public interface LOLBoardService {
	//�� ���
	List<LOLBoardVO> getBoardList(LOLCriteria cri);
	//�� ����+���Ͼ��ε�
	void insertBoard(LOLBoardVO vo, MultipartFile[] file)throws Exception;
	//��ȸ�� ����
	void updateBoardCount(int num);
	//�� ���� �ҷ�����
	LOLBoardVO readBoard(int num);
	//�� ����
	void update(LOLBoardVO vo);
	//�� ����
	void deleteBoard(int num);
	//���� ���� �ҷ�����
	List<Map<String, Object>> selectFileList(int num);
	int countBoardListTotal();
	void insertBoard(LOLBoardVO vo);
}
