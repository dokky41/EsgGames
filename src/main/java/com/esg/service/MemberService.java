package com.esg.service;

import java.util.List;

import com.esg.domain.MemberVO;
import com.esg.domain.esgMileVO;

public interface MemberService {

	int idCheck(String userid);

	void memberInsert(MemberVO vo);

	MemberVO loginCheck(MemberVO vo);

	void myPointCharge(MemberVO vo);

	void mileInsert(esgMileVO vo);

	String searchCnum();

	List<esgMileVO> getMyMileInfo(esgMileVO vo);

}
