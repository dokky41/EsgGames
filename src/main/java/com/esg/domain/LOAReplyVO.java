package com.esg.domain;

import java.sql.Timestamp;

public class LOAReplyVO {
	private int IDX; //�Խ��� ���� ��ȣ
	private int RNO; //��� ���� ��ȣ
	private String CONTENT; //��� ����
	private String WRITER; //��� �ۼ���
	private Timestamp REGDATE; //��� �ۼ� ��¥
	private int RECOMMEND; //��� ��õ��
	private int PARENT; //�θ� ��ȣ
	private int DEEP; //����
	
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
