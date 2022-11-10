package com.esg.persistence;

import java.util.List;

import javax.inject.Inject;
import com.esg.domain.Criteria;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.esg.domain.trMapleVO;

	
	@Repository
	public class TrMapleDAOImpl implements TrMapleDAO {
		
		private static final Logger log = LoggerFactory.getLogger(TrMapleDAOImpl.class);
		
		private static final String NAMESPACE="com.esg.mappers.TrMapleMapper";
		
		@Inject
		private SqlSession sqlSession;

		@Override//작성
		public void trMapleboardCreate(trMapleVO vo) {
			
			sqlSession.insert(NAMESPACE + ".TrMapleWrite", vo);
			
		}
        
		
		@Override//목록
		public List<trMapleVO> trMapleBoardList(Criteria cri) {
			
			return sqlSession.selectList(NAMESPACE + ".TrMapleList",cri);
			
		}
		
		@Override
		public List<trMapleVO> trMapleSearchList(Criteria cri) {
			
			return sqlSession.selectList(NAMESPACE + ".TrLoaSearchList",cri);
		}
		
		@Override //
		public int getTotalCnt() {
		
			return sqlSession.selectOne(NAMESPACE + ".TotalCnt");
		}

		
	

		@Override //수정
		public void getTrMapleModify(trMapleVO vo) {
			
			sqlSession.update(NAMESPACE+".TrMapleModify",vo);
			
		}

		@Override //삭제
		public void getTrMapleDelete(int num) {
			
			sqlSession.delete(NAMESPACE+".TrMapleDelete",num);
		}
	}

