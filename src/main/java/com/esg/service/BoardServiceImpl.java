package com.esg.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.esg.persistence.BoardDAO;
import com.esg.service.BoardService;
import com.esg.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject //dao∞¥√º ¡÷¿‘
	BoardDAO dao;
	
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);


	
	
}