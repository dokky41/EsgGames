package com.esg.persistence;

import java.util.List;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.esg.domain.LOLBoardVO;

@Repository
public class LOLBoardDAOImpl implements LOLBoardDAO {
	
	private static final Logger log = LoggerFactory.getLogger(LOLBoardDAOImpl.class);
	private static final String NAMESPACE="com.esg.mapper.LOLboardMapper";
	
	@Inject
	private SqlSession sqlSession;


	@Override
	public List<LOLBoardVO> getBoardList() {
		// TODO Auto-generated method stub
		log.info("getBoardList() »£√‚");
		List<LOLBoardVO> boardList = sqlSession.selectList(NAMESPACE+".BoardList");
		
		return boardList;
	}


	@Override
	public void insertBoard(LOLBoardVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE + ".write",vo);
	}
	

}
