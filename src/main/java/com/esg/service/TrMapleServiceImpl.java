package com.esg.service;

import java.util.List;

import javax.inject.Inject;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.esg.domain.trMapleVO;
import com.esg.domain.Criteria;
import com.esg.persistence.TrMapleDAO;

@Service
public class TrMapleServiceImpl implements TrMapleService{

	
	private static final Logger log = LoggerFactory.getLogger(TrMapleServiceImpl.class);

	@Inject
	TrMapleDAO dao;

	@Override // �� �ۼ�
	public void trMapleboardCreate(trMapleVO vo) {
		
		dao.trMapleboardCreate(vo);
		
	}

	@Override//�۰���
	public int TotalCnt() {
		return dao.getTotalCnt();
	}

	@Override//�۸��
	public List<trMapleVO> trMapleBoardList(Criteria cri) {
		
		return dao.trMapleBoardList(cri);
	}

	@Override
	public List<trMapleVO> trMapleSearchList(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.trMapleSearchList(cri);
	}
	
}
	