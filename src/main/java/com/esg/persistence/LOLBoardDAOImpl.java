package com.esg.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
		log.info("getBoardList() 호출");
		List<LOLBoardVO> boardList = sqlSession.selectList(NAMESPACE+".BoardList");
		
		return boardList;
	}
	
	

	@Override
	public void insertBoard(LOLBoardVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE + ".write",vo);
	}


	@Override
	public void updateBoardCnt(int num) {
		// TODO Auto-generated method stub
		log.info("readcount 증가");
		sqlSession.update(NAMESPACE+".updateBoardCnt",num);
	}


	@Override
	public LOLBoardVO getBoardContent(int num) {
		// TODO Auto-generated method stub
		LOLBoardVO vo = sqlSession.selectOne(NAMESPACE+".getBoard",num);
		return vo;
	}

	@Override
	public void update(LOLBoardVO vo) {
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

}
