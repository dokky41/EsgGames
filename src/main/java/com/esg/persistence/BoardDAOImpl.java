package com.esg.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.esg.domain.BoardVO;
import com.esg.persistence.BoardDAO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	private static final String NAMESPACE="com.esg.mapper.BoardMapper";
	
	@Inject
	private SqlSession sqlSession;

}
