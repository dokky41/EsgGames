package com.esg.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.esg.domain.MemberVO;
import com.esg.domain.esgMileVO;
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

	@Override
	public void myPointCharge(MemberVO vo) {
		dao.myPointCharge(vo);
	}

	@Override
	public void mileInsert(esgMileVO vo) {
		dao.mileInsert(vo);
	}

	@Override
	public String searchCnum() {
		
		String a = dao.searchCnum();
		
		// a 문자부분
		String b = "esgChNum";

		// a 숫자부분
		int c = 0;

		if (a == null) {

			b = "esgTestCNum";
			c = 0;
		} else {
			c = Integer.parseInt(a.replaceAll("[^0-9]", ""));

		}

		String d = b + (c + 1);

		return d;
	}

	@Override
	public List<esgMileVO> getMyMileInfo(esgMileVO vo) {
		return dao.getMyMileInfo(vo);
	}
	
	
	
	
}
