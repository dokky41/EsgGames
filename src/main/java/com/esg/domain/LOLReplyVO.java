package com.esg.domain;

import java.sql.Timestamp;

public class LOLReplyVO {
	private int IDX; //�Խ��� ���� ��ȣ
	private int RNO; //��� ���� ��ȣ
	private String CONTENT; //��� ����
	private String WRITER; //��� �ۼ���
	private Timestamp REGDATE; //��� �ۼ� ��¥
	
	public int getIDX() {
		return IDX;
	}
	public void setIDX(int iDX) {
		IDX = iDX;
	}
	public int getRNO() {
		return RNO;
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
				+ REGDATE + "]";
	}
	
	
}
