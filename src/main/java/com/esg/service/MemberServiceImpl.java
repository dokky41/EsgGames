package com.esg.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.esg.domain.MemberVO;
import com.esg.domain.esgChange;
import com.esg.domain.esgMileVO;
import com.esg.domain.esgmailVO;
import com.esg.domain.trLoaVO;
import com.esg.domain.trMailVO;
import com.esg.persistence.MemberDAO;
import com.esg.sms.ydTrSms;

@Service
public class MemberServiceImpl implements MemberService {

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

	@Override
	public void payExChange(esgChange vo) throws IOException, org.json.simple.parser.ParseException {
		// access_token 발급
		HttpURLConnection conn = null;
		URL url = new URL("https://api.iamport.kr/users/getToken");
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Accept", "application/json");
		conn.setDoOutput(true);
		JSONObject obj = new JSONObject();
		obj.put("imp_key", "3817682477122484");
		obj.put("imp_secret", "a060f160cc159fd09923a2ebfb7678adbac710c0105bedad238924b8d34a67409508e32f09830702");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		bw.write(obj.toString());
		bw.flush();
		bw.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line + "\n");
		}
		br.close();
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObj = (JSONObject) jsonParser.parse(sb.toString());
		JSONObject responseData = (JSONObject) jsonObj.get("response");
		String access_token = (String) responseData.get("access_token");

		log.info("액세스토큰 :" + access_token);

		// 자원해제
		if (conn != null) {
			conn.disconnect();
		}

		// REST API(결제환불) 호출
		HttpURLConnection conn2 = null;
		URL url2 = new URL("https://api.iamport.kr/payments/cancel");
		conn2 = (HttpURLConnection) url2.openConnection();
		conn2.setRequestMethod("POST");
		conn2.setRequestProperty("Content-Type", "application/json");
		conn2.setRequestProperty("Authorization", access_token);
		conn2.setDoOutput(true);
		JSONObject obj2 = new JSONObject();
		obj2.put("reason", "ESG 마일리지 환불");
		obj2.put("merchant_uid", vo.getChargeNum());
		obj2.put("amount", vo.getUserpoint());
		BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(conn2.getOutputStream()));
		bw2.write(obj2.toString());
		bw2.flush();
		bw2.close();
		BufferedReader br2 = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
		StringBuilder sb2 = new StringBuilder();
		String line2 = null;
		while ((line2 = br2.readLine()) != null) {
			sb2.append(line2 + "\n");
		}
		br2.close();

		// 자원해제
		if (conn2 != null) {
			conn2.disconnect();
		}
		
		
	}

	@Override
	public void exPutDB(esgChange vo) {
		//환불테이블 입력
		dao.exPutDB(vo);
		
	}

	@Override
	public void exMileTrans(esgChange vo) {
		//내 마일리지 수정
		dao.exMileTrans(vo);
		
	}

	@Override
	public void deleteMeInfo(MemberVO vo) {
		dao.deleteMeInfo(vo);
		
	}

	@Override
	public void getRefuse(trMailVO vo) {
		dao.getRefuse(vo);
		
	}

	@Override
	public List<trMailVO> getFromTrInfo(String userid) {
		return dao.getFromTrInfo(userid);
	}

	@Override
	public List<trMailVO> getToTrInfo(String userid) {
		return dao.getToTrInfo(userid);
	}

	@Override
	public void sendMail(esgmailVO vo) {
		dao.sendMail(vo);
		
	}

	@Override
	public List<trMailVO> getmailForm(String userid) {
		return dao.getmailForm(userid);
	}

	@Override
	public List<trMailVO> getmailTo(String userid) {
		return dao.getmailTo(userid);
	}

		
	
}
