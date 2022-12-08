package com.esg.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.esg.domain.LOABoardVO;
import com.esg.domain.LOASearchCriteria;

@Repository
public class LOABoardDAOImpl implements LOABoardDAO{
	private static final Logger log = LoggerFactory.getLogger(LOABoardDAOImpl.class);
	private static final String NAMESPACE="com.esg.mapper.LOAboardMapper";
	
	@Inject
	private SqlSession sqlSession;


	@Override
	public List<LOABoardVO> getBoardList(LOASearchCriteria cri) {
		// TODO Auto-generated method stub
		log.info("getBoardList() ȣ��");
		List<LOABoardVO> boardList = sqlSession.selectList(NAMESPACE+".BoardList",cri);
		
		return boardList;
	}
	
	@Override
	public void insertBoard(LOABoardVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE + ".write",vo);
	}


	@Override
	public void updateBoardCnt(int num) {
		// TODO Auto-generated method stub
		log.info("readcount ����");
		sqlSession.update(NAMESPACE+".updateBoardCnt",num);
	}


	@Override
	public LOABoardVO getBoardContent(int num) {
		// TODO Auto-generated method stub
		LOABoardVO vo = sqlSession.selectOne(NAMESPACE+".getBoard",num);
		return vo;
	}

	@Override
	public void update(LOABoardVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE+".update",vo);
	}


	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE+".delete",num);
	}
	
	public void insertFile(Map<String, Object> map) {
	    sqlSession.insert(NAMESPACE+".insertFile", map);
	}


	@Override
	public List<Map<String, Object>> selectFileList(int num) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".getBoardFile",num);
	}

	@Override
	public int countBoardList(LOASearchCriteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".countBoardList",cri);
	}

	@Override
	public void recommend(int num) {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE+".recommend",num);
	}
}
