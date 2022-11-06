package com.esg.persistence;

import com.esg.domain.MemberVO;

public interface MemberDAO {

	public int idcheck(String userid);

	public void insertMember(MemberVO vo);

	public MemberVO logincheck(MemberVO vo);


}
