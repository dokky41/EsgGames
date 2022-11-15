package com.esg.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.esg.domain.Criteria;
import com.esg.domain.mapleboardVO;
import com.esg.persistence.mapleboardDAO;

@Service
public class mapleboardServiceImpl implements mapleboardService {

	private static final Logger log = LoggerFactory.getLogger(mapleboardServiceImpl.class);
	
	@Inject
	mapleboardDAO dao;
	
	@Override
	public void mapleboardwrite(mapleboardVO vo) {
		// TODO Auto-generated method stub
		//log.info(vo+"");
		dao.mapleboardwrite(vo);
	}

	@Override
	public List<mapleboardVO> mapleboardlist(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.mapleboardlist(cri);
	}

	@Override
	public List<mapleboardVO> mapleSearchList(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.mapleSearchList(cri);
	}
	
	

	@Override
	public void getmaplemodify(mapleboardVO vo) {
		// TODO Auto-generated method stub
		dao.getmaplemodify(vo);
		
	}
	
	@Override
	public mapleboardVO getmapleContent(int num) {
		// TODO Auto-generated method stub
		return dao.getmapleContent(num);
	}

	@Override
	public void getmapledelete(int num) {
		// TODO Auto-generated method stub
		dao.getmapledelete(num);
		
	}

	@Override
	public int totalCnt() {
		// TODO Auto-generated method stub
		return dao.totalCnt();
	}

	@Override
	public void updatemapleBoardCount(int num) {
		// TODO Auto-generated method stub
		dao.updatemapleBoardCount(num);
	}

	

	

	

}
