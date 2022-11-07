package com.esg.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.esg.domain.LOLBoardVO;

public interface LOLBoardService {
	//�� ���
	List<LOLBoardVO> getBoardList();
	//�� ����
	void insertBoard(LOLBoardVO vo, MultipartHttpServletRequest mpRequest);
	//��ȸ�� ����
	void updateBoardCount(int num);
	//�� ���� �ҷ�����
	LOLBoardVO readBoard(int num);
	//�� ����
	void update(LOLBoardVO vo);
	//�� ����
	void deleteBoard(int num);



}
