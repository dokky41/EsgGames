package com.esg.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.esg.domain.MemberVO;

import jdk.internal.org.jline.utils.Log;


@Repository
public class MemberDAOImpl implements MemberDAO {

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
		
		Log.info("회원가입 완료");
		
	}

	@Override
	public MemberVO logincheck(MemberVO vo) {
		
		MemberVO membervo = sqlSession.selectOne(NAMESPACE+".logincheck", vo);
		
		return membervo;
	}
	


}
