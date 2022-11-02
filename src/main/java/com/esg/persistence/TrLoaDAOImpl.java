package com.esg.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.esg.domain.Criteria;
import com.esg.domain.trLoaVO;

@Repository
public class TrLoaDAOImpl implements TrLoaDAO {
	
	private static final Logger log = LoggerFactory.getLogger(TrLoaDAOImpl.class);
	
	private static final String NAMESPACE="com.esg.mapper.TrLoaMapper";
	
	@Inject
	private SqlSession sqlSession;

	//로아 거래글 등록
	@Override
	public void trLoaboardCreate(trLoaVO vo) {
		
		sqlSession.insert(NAMESPACE + ".TrLoainsert", vo);
		
	}

	@Override
	public List<trLoaVO> trLoaBoardList(Criteria cri) {
		
		return sqlSession.selectList(NAMESPACE + ".TrLoaList",cri);
		
	}

	@Override
	public int getTotalCnt() {
		return sqlSession.selectOne(NAMESPACE+".totalCnt");
	}

	@Override
	public List<trLoaVO> trLoaSearchList(Criteria cri) {
		return sqlSession.selectList(NAMESPACE + ".TrLoaSearchList",cri);
	}

	
	
	
	
	
	
}
