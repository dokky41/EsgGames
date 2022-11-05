package com.esg.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


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
	public List<mapleboardVO> mapleboardlist() {
		// TODO Auto-generated method stub
		return dao.mapleboardlist();
	}

}
