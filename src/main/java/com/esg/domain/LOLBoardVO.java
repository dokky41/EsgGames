package com.esg.domain;

import java.sql.Timestamp;

public class LOLBoardVO {
	private int IDX;
	private int PRE_IDX;
	private String TITLE;
	private String CONTENTS;
	private int HIT_CNT;
	private String DEL_CHK;
	private Timestamp CREA_DATE;
	private String CREA_ID;
	public int getIDX() {
		return IDX;
	}
	public void setIDX(int iDX) {
		IDX = iDX;
	}
	public int getPRE_IDX() {
		return PRE_IDX;
	}
	public void setPRE_IDX(int pRE_IDX) {
		PRE_IDX = pRE_IDX;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getCONTENTS() {
		return CONTENTS;
	}
	public void setCONTENTS(String cONTENTS) {
		CONTENTS = cONTENTS;
	}
	public int getHIT_CNT() {
		return HIT_CNT;
	}
	public void setHIT_CNT(int hIT_CNT) {
		HIT_CNT = hIT_CNT;
	}
	public String getDEL_CHK() {
		return DEL_CHK;
	}
	public void setDEL_CHK(String dEL_CHK) {
		DEL_CHK = dEL_CHK;
	}
	public Timestamp getCREA_DATE() {
		return CREA_DATE;
	}
	public void setCREA_DATE(Timestamp cREA_DATE) {
		CREA_DATE = cREA_DATE;
	}
	public String getCREA_ID() {
		return CREA_ID;
	}
	public void setCREA_ID(String cREA_ID) {
		CREA_ID = cREA_ID;
	}
	@Override
	public String toString() {
		return "BoardVO [IDX=" + IDX + ", PRE_IDX=" + PRE_IDX + ", TITLE=" + TITLE + ", CONTENTS=" + CONTENTS
				+ ", HIT_CNT=" + HIT_CNT + ", DEL_CHK=" + DEL_CHK + ", CREA_DATE=" + CREA_DATE + ", CREA_ID=" + CREA_ID
				+ "]";
	}
	
}
