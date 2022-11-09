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
	private int BOARD_IDX;
	private String ORG_FILE_NAME;
	private String SAVE_FILE_NAME;
	private int FILE_SIZE;
	private String UPDATE_DATE;

	
	
	
	public int getBOARD_IDX() {
		return BOARD_IDX;
	}
	public void setBOARD_IDX(int bOARD_IDX) {
		BOARD_IDX = bOARD_IDX;
	}
	public String getORG_FILE_NAME() {
		return ORG_FILE_NAME;
	}
	public void setORG_FILE_NAME(String oRG_FILE_NAME) {
		ORG_FILE_NAME = oRG_FILE_NAME;
	}
	public String getSAVE_FILE_NAME() {
		return SAVE_FILE_NAME;
	}
	public void setSAVE_FILE_NAME(String sAVE_FILE_NAME) {
		SAVE_FILE_NAME = sAVE_FILE_NAME;
	}
	public int getFILE_SIZE() {
		return FILE_SIZE;
	}
	public void setFILE_SIZE(int fILE_SIZE) {
		FILE_SIZE = fILE_SIZE;
	}
	public String getUPDATE_DATE() {
		return UPDATE_DATE;
	}
	public void setUPDATE_DATE(String uPDATE_DATE) {
		UPDATE_DATE = uPDATE_DATE;
	}
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
		return "LOLBoardVO [IDX=" + IDX + ", PRE_IDX=" + PRE_IDX + ", TITLE=" + TITLE + ", CONTENTS=" + CONTENTS
				+ ", HIT_CNT=" + HIT_CNT + ", DEL_CHK=" + DEL_CHK + ", CREA_DATE=" + CREA_DATE + ", CREA_ID=" + CREA_ID
				+ ", BOARD_IDX=" + BOARD_IDX + ", ORG_FILE_NAME=" + ORG_FILE_NAME + ", SAVE_FILE_NAME=" + SAVE_FILE_NAME
				+ ", FILE_SIZE=" + FILE_SIZE + ", UPDATE_DATE=" + UPDATE_DATE + "]";
	}
	
}
