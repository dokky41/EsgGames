package com.esg.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.annotation.Resource;

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
	public void insertBoard(LOLBoardVO vo){
		// TODO Auto-generated method stub
		dao.insertBoard(vo);
		
	}

	@Override
	public void updateBoardCount(int num) {
		// TODO Auto-generated method stub
		dao.updateBoardCnt(num);
	}

	@Override
	public LOLBoardVO readBoard(int num) {
		// TODO Auto-generated method stub
		LOLBoardVO vo = dao.getBoardContent(num);
		return vo;
	}

	@Override
	public void update(LOLBoardVO vo) {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void deleteBoard(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
		
	}
}