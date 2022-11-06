package com.esg.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.esg.domain.trMapleVO;
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

	@Override //�� ���
	public List<trMapleVO> trMapleboardList() {
		// TODO Auto-generated method stub
		return dao.trMapleboardList();
		
	}
	
}
	