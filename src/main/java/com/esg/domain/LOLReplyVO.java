package com.esg.domain;

import java.sql.Timestamp;

public class LOLReplyVO {
	private int IDX; //게시판 고유 번호
	private int RNO; //댓글 고유 번호
	private String CONTENT; //댓글 내용
	private String WRITER; //댓글 작성자
	private Timestamp REGDATE; //댓글 작성 날짜
	private int RECOMMEND; //댓글 추천수
	
	public int getIDX() {
		return IDX;
	}
	public void setIDX(int iDX) {
		IDX = iDX;
	}
	public int getRNO() {
		return RNO;
	}
	public int getRECOMMEND() {
		return RECOMMEND;
	}
	public void setRECOMMEND(int rECOMMEND) {
		RECOMMEND = rECOMMEND;
	}
	public void setRNO(int rNO) {
		RNO = rNO;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	public String getWRITER() {
		return WRITER;
	}
	public void setWRITER(String wRITER) {
		WRITER = wRITER;
	}
	public Timestamp getREGDATE() {
		return REGDATE;
	}
	public void setREGDATE(Timestamp rEGDATE) {
		REGDATE = rEGDATE;
	}
	@Override
	public String toString() {
		return "LOLReplyVO [IDX=" + IDX + ", RNO=" + RNO + ", CONTENT=" + CONTENT + ", WRITER=" + WRITER + ", REGDATE="
				+ REGDATE + ", RECOMMEND=" + RECOMMEND + "]";
	}
	
	
}
