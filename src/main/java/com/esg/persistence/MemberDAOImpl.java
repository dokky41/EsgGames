package com.esg.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.esg.domain.MemberVO;
import com.esg.domain.esgMileVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);

	private static final String NAMESPACE = "com.esg.mapper.MemberMapper";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public int idcheck(String userid) {
		
		int result = sqlSession.selectOne(NAMESPACE+".idcheck", userid);
		
		return result;
	}

	@Override
	public void insertMember(MemberVO vo) {
		
		log.info("회원가입 실행!");
		
		sqlSession.insert(NAMESPACE+".insertMember",vo);
		
		log.info("회원가입 완료");
		
	}

	@Override
	public MemberVO logincheck(MemberVO vo) {
		
		MemberVO membervo = sqlSession.selectOne(NAMESPACE+".loginCheck", vo);
		
		return membervo;
	}

	@Override
	public void myPointCharge(MemberVO vo) {
		sqlSession.update(NAMESPACE+".pointCharge", vo);
	}

	@Override
	public void mileInsert(esgMileVO vo) {
		sqlSession.insert(NAMESPACE+".mileInsert", vo);
		
	}

	@Override
	public String searchCnum() {
		return sqlSession.selectOne(NAMESPACE + ".getSearchCnum");
	}

	@Override
	public List<esgMileVO> getMyMileInfo(esgMileVO vo) {
		return sqlSession.selectList(NAMESPACE+".getMyMileSearch",vo);
	}
	


}
