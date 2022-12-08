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
import com.esg.domain.trLolVO;
import com.esg.domain.trMailVO;

@Repository
public class TrLolDAOImpl implements TrLolDAO {
	
	private static final Logger log = LoggerFactory.getLogger(TrLolDAOImpl.class);
	
	private static final String NAMESPACE="com.esg.mapper.TrLolMapper";
	
	@Inject
	private SqlSession sqlSession;

	//로아 거래글 등록
	@Override
	public void trLolboardCreate(trLolVO vo) {
		
		sqlSession.insert(NAMESPACE + ".TrLolinsert", vo);
		
	}

	@Override
	public List<trLolVO> trLolBoardList(Criteria cri) {
		
		return sqlSession.selectList(NAMESPACE + ".TrLolList",cri);
		
	}

	@Override
	public int getTotalCnt() {
		return sqlSession.selectOne(NAMESPACE+".lolTotalCnt");
	}

	@Override
	public List<trLolVO> trLolSearchList(Criteria cri) {
		return sqlSession.selectList(NAMESPACE + ".TrLolSearchList",cri);
	}

	//로아글 상세내용
	@Override
	public trLolVO getTrLolContent(int num) {
		return sqlSession.selectOne(NAMESPACE + ".TrLolContent",num);
	}

	@Override
	public int getTotalCnt2(String searchName) {
		return sqlSession.selectOne(NAMESPACE+".lolTotalCnt2",searchName);
	}

	//글 수정
	@Override
	public void getTrLolModify(trLolVO vo) {
		sqlSession.update(NAMESPACE+".TrLolModify",vo);
		
	}

	//글 삭제
	@Override
	public void getTrLolDelete(int num) {
		sqlSession.delete(NAMESPACE+".TrLolDelete",num);
		
	}

	//글 조회수 증가
	@Override
	public void updateTrBoardCount(int num) {
		sqlSession.delete(NAMESPACE+".TrLolCount",num);
	}

	@Override
	public List<trLolVO> trLolBoardSelList(Criteria cri) {
		return sqlSession.selectList(NAMESPACE + ".TrLolSelList",cri);
	}

	@Override
	public List<trLolVO> trLolBoardPriList(Criteria cri) {
		return sqlSession.selectList(NAMESPACE + ".TrLolPriList",cri);
	}

	@Override
	public List<trLolVO> trLolBoardPriList2(Criteria cri) {
		return sqlSession.selectList(NAMESPACE + ".TrLolPriList2",cri);
	}

	@Override
	public void lolTrRequestMail(trMailVO vo) {
		sqlSession.insert(NAMESPACE+".lolTrSendRequest",vo);
	}


	
	
	
	
	
	
	
}
