package com.esg.service;

import java.util.List;

import com.esg.domain.Criteria;
import com.esg.domain.trMapleVO;

public interface TrMapleService {
	
	void trMapleboardCreate(trMapleVO vo); //�� �ۼ�


	List<trMapleVO> trMapleSearchList(Criteria cri); //��ϰ˻�


	int TotalCnt(); //�۰���


	List<trMapleVO> trMapleBoardList(Criteria cri); //�۸��
	
	

	

}