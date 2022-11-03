package com.esg.service;

import java.util.List;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.esg.persistence.LOLBoardDAO;
import com.esg.domain.LOLBoardVO;

@Service
public class LOLBoardServiceImpl implements LOLBoardService {

	@Inject //dao∞¥√º ¡÷¿‘
	LOLBoardDAO dao;
	
	private static final Logger log = LoggerFactory.getLogger(LOLBoardServiceImpl.class);

	@Override
	public List<LOLBoardVO> getBoardList() {
		// TODO Auto-generated method stub
		return dao.getBoardList();
	}

	@Override
	public void insertBoard(LOLBoardVO vo) {
		// TODO Auto-generated method stub
		dao.insertBoard(vo);
		
	}


	

	

	


	
	
}