package com.esg.service;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.esg.domain.MemberVO;
import com.esg.domain.esgChange;
import com.esg.domain.esgMileVO;
import com.esg.domain.esgmailVO;
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

	//문자보내기
	String smsShoot(String phNum);

	//아이디 가져오기
	String getIdSearch(MemberVO vo);

	//비밀번호 재발급전 확인
	String getPwSearch(MemberVO vo);

	//비밀번호 재발급
	void updateRePw(MemberVO vo);

	//내 정보 변경
	void updateMeInfo(MemberVO vo);

	//환불
	void payExChange(esgChange vo) throws IOException, ParseException;

	//환불테이블
	void exPutDB(esgChange vo);

	//마일리지 업데이트
	void exMileTrans(esgChange vo);

	//내 정보 삭제
	void deleteMeInfo(MemberVO vo);

	//거래 거절
	void getRefuse(trMailVO vo);

	//구매자
	List<trMailVO> getFromTrInfo(String userid);

	//판매자
	List<trMailVO> getToTrInfo(String userid);

	//메일보내기
	void sendMail(esgmailVO vo);

	//받은 메일함
	List<trMailVO> getmailForm(String userid);
	
	//보낸 메일함
	List<trMailVO> getmailTo(String userid);
	
	
}
