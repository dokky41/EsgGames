package com.esg.service;

import java.util.List;
import java.util.Map;

import com.esg.domain.LOLBoardVO;

public interface LOLBoardService {
	//�� ���
	List<LOLBoardVO> getBoardList();
	//�� ����
	void insertBoard(LOLBoardVO vo);
	//��ȸ�� ����
	void updateBoardCount(int num);
	//�� ���� �ҷ�����
	LOLBoardVO readBoard(int num);
	//�� ����
	void update(LOLBoardVO vo);
	//�� ����
	void deleteBoard(int num);



}
