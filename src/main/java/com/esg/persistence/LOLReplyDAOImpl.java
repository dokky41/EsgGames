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

	// ��� ��ȸ
	@Override
	public List<LOLReplyVO> list(int num) throws Exception  {
		return sqlSession.selectList(NAMESPACE + ".replyList", num);
	}

	// ��� �ۼ�
	@Override
	public void write(LOLReplyVO vo) throws Exception {
		sqlSession.insert(NAMESPACE + ".replyWrite", vo);
	}

	// ��� ����
	@Override
	public void update(LOLReplyVO vo) throws Exception {
		sqlSession.update(NAMESPACE + ".replyUpdate", vo);
	}

	// ��� ����
	@Override
	public void delete(LOLReplyVO vo) throws Exception {
		sqlSession.delete(NAMESPACE + ".replyDelete", vo);
	}
	// ���� ��� ��ȸ
	@Override
	public LOLReplyVO replySelect(LOLReplyVO vo) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE + ".replySelect", vo);
	}

	@Override
	public void recommend(int num) {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE+".recommend",num);
	}

	@Override
	public void Rwrite(LOLReplyVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE + ".RreplyWrite", vo);
	}
}
