package com.esg.service;

import java.util.List;

import com.esg.domain.MemberVO;
import com.esg.domain.esgMileVO;
import com.esg.domain.trLoaVO;
import com.esg.domain.trMailVO;

public interface MemberService {

	int idCheck(String userid);

	void memberInsert(MemberVO vo);

	MemberVO loginCheck(MemberVO vo);

	void myPointCharge(MemberVO vo);

	void mileInsert(esgMileVO vo);

	String searchCnum();

	List<esgMileVO> getMyMileInfo(esgMileVO vo);
	
	List<trMailVO> getMyTrInfo(String userid);

	//구매자 마일리지 조회
	int tradeMileGet(trLoaVO vo3);

	//거래상태업데이트
	void trUpdateMail(trMailVO vo);

	//판매자 마일리지 변환
	void sellerMileTrans(MemberVO vo2);

	//구매자 마일리지 변환
	void buyerMileTrans(MemberVO vo2);
}
