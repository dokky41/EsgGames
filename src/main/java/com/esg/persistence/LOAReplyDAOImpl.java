package com.esg.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.esg.domain.LOAReplyVO;

@Repository
public class LOAReplyDAOImpl implements LOAReplyDAO{
	private static final Logger log = LoggerFactory.getLogger(LOAReplyDAOImpl.class);
	private static final String NAMESPACE="com.esg.mapper.LOAreplyMapper";
	
	@Inject
	private SqlSession sqlSession;

	// ��� ��ȸ
	@Override
	public List<LOAReplyVO> list(int num) throws Exception  {
		return sqlSession.selectList(NAMESPACE + ".replyList", num);
	}

	// ��� �ۼ�
	@Override
	public void write(LOAReplyVO vo) throws Exception {
		sqlSession.insert(NAMESPACE + ".replyWrite", vo);
	}

	// ��� ����
	@Override
	public void update(LOAReplyVO vo) throws Exception {
		sqlSession.update(NAMESPACE + ".replyUpdate", vo);
	}

	// ��� ����
	@Override
	public void delete(LOAReplyVO vo) throws Exception {
		sqlSession.delete(NAMESPACE + ".replyDelete", vo);
	}
	// ���� ��� ��ȸ
	@Override
	public LOAReplyVO replySelect(LOAReplyVO vo) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE + ".replySelect", vo);
	}

	@Override
	public void recommend(int num) {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE+".recommend",num);
	}

	@Override
	public void Rwrite(LOAReplyVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE + ".RreplyWrite", vo);
	}
}
