package com.esg.domain;

import java.sql.Timestamp;

public class LOAReplyVO {
	private int IDX; //게시판 고유 번호
	private int RNO; //댓글 고유 번호
	private String CONTENT; //댓글 내용
	private String WRITER; //댓글 작성자
	private Timestamp REGDATE; //댓글 작성 날짜
	private int RECOMMEND; //댓글 추천수
	private int PARENT; //부모 번호
	private int DEEP; //깊이
	
	public int getPARENT() {
		return PARENT;
	}
	public void setPARENT(int pARENT) {
		PARENT = pARENT;
	}
	public int getDEEP() {
		return DEEP;
	}
	public void setDEEP(int dEEP) {
		DEEP = dEEP;
	}

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
		return "LOAReplyVO [IDX=" + IDX + ", RNO=" + RNO + ", CONTENT=" + CONTENT + ", WRITER=" + WRITER + ", REGDATE="
				+ REGDATE + ", RECOMMEND=" + RECOMMEND + ", PARENT=" + PARENT + ", DEEP=" + DEEP + "]";
	}
	
	
}
