package com.esg.service;

import com.esg.domain.MemberVO;

public interface MemberService {

	int idCheck(String userid);

	void memberInsert(MemberVO vo);

	MemberVO loginCheck(MemberVO vo);

}
