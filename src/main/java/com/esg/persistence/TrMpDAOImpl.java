package com.esg.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.esg.domain.Criteria;
import com.esg.domain.MemberVO;
import com.esg.domain.trLoaVO;
import com.esg.domain.trMailVO;
import com.esg.domain.trMpVO;

@Repository
public class TrMpDAOImpl implements TrMpDAO {
	
	private static final Logger log = LoggerFactory.getLogger(TrMpDAOImpl.class);
	
	private static final String NAMESPACE="com.esg.mapper.TrMpMapper";
	
	@Inject
	private SqlSession sqlSession;

	//로아 거래글 등록
	@Override
	public void trMpboardCreate(trMpVO vo) {
		
		sqlSession.insert(NAMESPACE + ".TrMpinsert", vo);
		
	}

	@Override
	public List<trMpVO> trMpBoardList(Criteria cri) {
		
		return sqlSession.selectList(NAMESPACE + ".TrMpList",cri);
		
	}

	@Override
	public int getTotalCnt() {
		return sqlSession.selectOne(NAMESPACE+".mpTotalCnt");
	}

	@Override
	public List<trMpVO> trMpSearchList(Criteria cri) {
		return sqlSession.selectList(NAMESPACE + ".TrMpSearchList",cri);
	}

	//로아글 상세내용
	@Override
	public trMpVO getTrMpContent(int num) {
		return sqlSession.selectOne(NAMESPACE + ".TrMpContent",num);
	}

	@Override
	public int getTotalCnt2(String searchName) {
		return sqlSession.selectOne(NAMESPACE+".totalCnt2",searchName);
	}

	//글 수정
	@Override
	public void getTrMpModify(trMpVO vo) {
		sqlSession.update(NAMESPACE+".TrMpModify",vo);
		
	}

	//글 삭제
	@Override
	public void getTrMpDelete(int num) {
		sqlSession.delete(NAMESPACE+".TrMpDelete",num);
		
	}

	//글 조회수 증가
	@Override
	public void updateTrBoardCount(int num) {
		sqlSession.delete(NAMESPACE+".TrMpCount",num);
	}

	@Override
	public List<trMpVO> trMpBoardSelList(Criteria cri) {
		return sqlSession.selectList(NAMESPACE + ".TrMpSelList",cri);
	}

	@Override
	public List<trMpVO> trMpBoardPriList(Criteria cri) {
		return sqlSession.selectList(NAMESPACE + ".TrMpPriList",cri);
	}

	@Override
	public List<trMpVO> trMpBoardPriList2(Criteria cri) {
		return sqlSession.selectList(NAMESPACE + ".TrMpPriList2",cri);
	}

	@Override
	public void trRequestMail(trMailVO vo) {
		sqlSession.insert(NAMESPACE+".trSendRequest",vo);
	}


	
	
	
	
	
	
	
}
