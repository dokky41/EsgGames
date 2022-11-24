package com.esg.persistence;

import java.util.List;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.esg.domain.LOLReplyVO;

@Repository
public class LOLReplyDAOImpl implements LOLReplyDAO{
	
	private static final Logger log = LoggerFactory.getLogger(LOLReplyDAOImpl.class);
	private static final String NAMESPACE="com.esg.mapper.LOLreplyMapper";
	
	@Inject
	private SqlSession sqlSession;

	// ¥Ò±€ ¡∂»∏
	@Override
	public List<LOLReplyVO> list(int num) throws Exception  {
		return sqlSession.selectList(NAMESPACE + ".replyList", num);
	}

	// ¥Ò±€ ¿€º∫
	@Override
	public void write(LOLReplyVO vo) throws Exception {
		sqlSession.insert(NAMESPACE + ".replyWrite", vo);
	}

	// ¥Ò±€ ºˆ¡§
	@Override
	public void modify(LOLReplyVO vo) throws Exception {
		sqlSession.update(NAMESPACE + ".replyModify", vo);
	}

	// ¥Ò±€ ªË¡¶
	@Override
	public void delete(LOLReplyVO vo) throws Exception {
		sqlSession.delete(NAMESPACE + ".replyDelete", vo);
	}
}
