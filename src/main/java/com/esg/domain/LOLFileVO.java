package com.esg.domain;

import java.sql.Timestamp;

public class LOLFileVO {
	private int IDX;
	private int BOARD_IDX;
	private String ORG_FILE_NAME;
	private String SAVE_FILE_NAME;
	private int FILE_SIZE;
	private Timestamp UPDATE_DATE;
	private String CREA_ID;
	private String DEL_CHK;
	private Timestamp CREA_DATE;
	public int getIDX() {
		return IDX;
	}
	public void setIDX(int iDX) {
		IDX = iDX;
	}
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
	public Timestamp getUPDATE_DATE() {
		return UPDATE_DATE;
	}
	public void setUPDATE_DATE(Timestamp uPDATE_DATE) {
		UPDATE_DATE = uPDATE_DATE;
	}
	public String getCREA_ID() {
		return CREA_ID;
	}
	public void setCREA_ID(String cREA_ID) {
		CREA_ID = cREA_ID;
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
	@Override
	public String toString() {
		return "LOLFileVO [IDX=" + IDX + ", BOARD_IDX=" + BOARD_IDX + ", ORG_FILE_NAME=" + ORG_FILE_NAME
				+ ", SAVE_FILE_NAME=" + SAVE_FILE_NAME + ", FILE_SIZE=" + FILE_SIZE + ", UPDATE_DATE=" + UPDATE_DATE
				+ ", CREA_ID=" + CREA_ID + ", DEL_CHK=" + DEL_CHK + ", CREA_DATE=" + CREA_DATE + "]";
	}
}
