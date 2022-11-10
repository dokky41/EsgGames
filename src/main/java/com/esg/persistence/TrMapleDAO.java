package com.esg.persistence;

import java.util.List;


import com.esg.domain.trMapleVO;

import com.esg.domain.Criteria;

public interface TrMapleDAO {

	    //�� ���ε�
		void trMapleboardCreate(trMapleVO vo);

		//�۸��
		List<trMapleVO> trMapleBoardList(Criteria cri);
		

		//����ü����
		int getTotalCnt();

		

		//�ۼ���
		void getTrMapleModify(trMapleVO vo);

		//�ۻ���
		void getTrMapleDelete(int num);

		//��ϰ˻�
		List<trMapleVO> trMapleSearchList(Criteria cri);

		
}
