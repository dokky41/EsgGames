package com.esg.persistence;

import java.util.List;

import com.esg.domain.MemberVO;
import com.esg.domain.esgChange;
import com.esg.domain.esgMileVO;
import com.esg.domain.esgmailVO;
import com.esg.domain.trLoaVO;
import com.esg.domain.trMailVO;

public interface MemberDAO {

	public int idcheck(String userid);

	public void insertMember(MemberVO vo);

	public MemberVO logincheck(MemberVO vo);

	public void myPointCharge(MemberVO vo);

	public void mileInsert(esgMileVO vo);

	public String searchCnum();

	public List<esgMileVO> getMyMileInfo(esgMileVO vo);

	public List<trMailVO> getMyTrInfo(String userid);

	int tradeMileGet(trLoaVO vo3);
	
	void trUpdateMail(trMailVO vo);

	void sellerMileTrans(MemberVO vo2);

	void buyerMileTrans(MemberVO vo2);
	
	void exMileTrans(esgChange vo);

	public String getIdSearch(MemberVO vo);

	public String getPwSearch(MemberVO vo);

	public void updateRePw(MemberVO vo);

	public void updateMeInfo(MemberVO vo);

	public void exPutDB(esgChange vo);

	public void deleteMeInfo(MemberVO vo);

	public void getRefuse(trMailVO vo);

	public List<trMailVO> getFromTrInfo(String userid);

	public List<trMailVO> getToTrInfo(String userid);

	public void sendMail(esgmailVO vo);

	public List<trMailVO> getmailForm(String userid);

	public List<trMailVO> getmailTo(String userid);
	
	
}
