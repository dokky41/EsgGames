package com.esg.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.esg.domain.Criteria;
import com.esg.domain.MemberVO;
import com.esg.domain.trBgVO;
import com.esg.domain.trLoaVO;
import com.esg.domain.trMailVO;
import com.esg.domain.trMpVO;

@Repository
public class TrBgDAOImpl implements TrBgDAO {
	
	private static final Logger log = LoggerFactory.getLogger(TrBgDAOImpl.class);
	
	private static final String NAMESPACE="com.esg.mapper.TrBgMapper";
	
	@Inject
	private SqlSession sqlSession;

	//로아 거래글 등록
	@Override
	public void trBgboardCreate(trBgVO vo) {
		
		sqlSession.insert(NAMESPACE + ".TrBginsert", vo);
		
	}

	@Override
	public List<trBgVO> trBgBoardList(Criteria cri) {
		
		return sqlSession.selectList(NAMESPACE + ".TrBgList",cri);
		
	}

	@Override
	public int getTotalCnt() {
		return sqlSession.selectOne(NAMESPACE+".bgTotalCnt");
	}

	@Override
	public List<trBgVO> trBgSearchList(Criteria cri) {
		return sqlSession.selectList(NAMESPACE + ".TrBgSearchList",cri);
	}

	//로아글 상세내용
	@Override
	public trBgVO getTrBgContent(int num) {
		return sqlSession.selectOne(NAMESPACE + ".TrBgContent",num);
	}

	@Override
	public int getTotalCnt2(String searchName) {
		return sqlSession.selectOne(NAMESPACE+".totalCnt2",searchName);
	}

	//글 수정
	@Override
	public void getTrBgModify(trBgVO vo) {
		sqlSession.update(NAMESPACE+".TrBgModify",vo);
		
	}

	//글 삭제
	@Override
	public void getTrBgDelete(int num) {
		sqlSession.delete(NAMESPACE+".TrBgDelete",num);
		
	}

	//글 조회수 증가
	@Override
	public void updateTrBoardCount(int num) {
		sqlSession.delete(NAMESPACE+".TrBgCount",num);
	}

	@Override
	public List<trBgVO> trBgBoardSelList(Criteria cri) {
		return sqlSession.selectList(NAMESPACE + ".TrBgSelList",cri);
	}

	@Override
	public List<trBgVO> trBgBoardPriList(Criteria cri) {
		return sqlSession.selectList(NAMESPACE + ".TrBgPriList",cri);
	}

	@Override
	public List<trBgVO> trBgBoardPriList2(Criteria cri) {
		return sqlSession.selectList(NAMESPACE + ".TrBgPriList2",cri);
	}

	@Override
	public void trRequestMail(trMailVO vo) {
		sqlSession.insert(NAMESPACE+".trSendRequest",vo);
	}


	
	
	
	
	
	
	
}
