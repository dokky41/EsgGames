package com.esg.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.esg.domain.MemberVO;
import com.esg.domain.esgMileVO;
import com.esg.domain.trLoaVO;
import com.esg.domain.trMailVO;
import com.esg.persistence.MemberDAO;
import com.esg.sms.ydTrSms;

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

	@Override
	public List<trMailVO> getMyTrInfo(String userid) {
		return dao.getMyTrInfo(userid);
	}
	
	@Override
	public int tradeMileGet(trLoaVO vo3) {
		return dao.tradeMileGet(vo3);
	}
	
	@Override
	public void trUpdateMail(trMailVO vo) {
		dao.trUpdateMail(vo);
	}

	@Override
	public void sellerMileTrans(MemberVO vo2) {
		dao.sellerMileTrans(vo2);
		
	}
	
	@Override
	public void buyerMileTrans(MemberVO vo2) {
		dao.buyerMileTrans(vo2);
		
	}

	@Override
	public String smsShoot(String phNum) {
		return ydTrSms.aa(phNum);
		
	}

	@Override
	public String getIdSearch(MemberVO vo) {
		return dao.getIdSearch(vo);
		
	}

	@Override
	public String getPwSearch(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.getPwSearch(vo);
	}

	@Override
	public void updateRePw(MemberVO vo) {
		// TODO Auto-generated method stub
		dao.updateRePw(vo);
	}

	@Override
	public void updateMeInfo(MemberVO vo) {
		dao.updateMeInfo(vo);
		
	}
	
	
}
