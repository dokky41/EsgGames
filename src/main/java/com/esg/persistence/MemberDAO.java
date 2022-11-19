package com.esg.persistence;

import java.util.List;

import com.esg.domain.MemberVO;
import com.esg.domain.esgMileVO;

public interface MemberDAO {

	public int idcheck(String userid);

	public void insertMember(MemberVO vo);

	public MemberVO logincheck(MemberVO vo);

	public void myPointCharge(MemberVO vo);

	public void mileInsert(esgMileVO vo);

	public String searchCnum();

	public List<esgMileVO> getMyMileInfo(esgMileVO vo);

	
}
