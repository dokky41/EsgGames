package com.esg.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.esg.domain.MemberVO;
import com.esg.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Inject
	MemberDAO dao;

	@Override
	public int idCheck(String userid) {
		
		return dao.idcheck(userid);
	}

	@Override
	public void memberInsert(MemberVO vo) {
		
		dao.insertMember(vo);
	}

	@Override
	public MemberVO loginCheck(MemberVO vo) {
		
		MemberVO membervo = dao.logincheck(vo);
		
		return membervo;
	}
}
