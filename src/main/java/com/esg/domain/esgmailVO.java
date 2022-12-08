package com.esg.domain;

import java.sql.Timestamp;

public class esgmailVO {

	private int emNum;
	private String mSubject;
	private String mContent;
	private Timestamp date;
	private String mSender;
	private String mReceiver;
	public int getEmNum() {
		return emNum;
	}
	public void setEmNum(int emNum) {
		this.emNum = emNum;
	}
	public String getmSubject() {
		return mSubject;
	}
	public void setmSubject(String mSubject) {
		this.mSubject = mSubject;
	}
	public String getmContent() {
		return mContent;
	}
	public void setmContent(String mContent) {
		this.mContent = mContent;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getmSender() {
		return mSender;
	}
	public void setmSender(String mSender) {
		this.mSender = mSender;
	}
	public String getmReceiver() {
		return mReceiver;
	}
	public void setmReceiver(String mReceiver) {
		this.mReceiver = mReceiver;
	}
	@Override
	public String toString() {
		return "esgmailVO [emNum=" + emNum + ", mSubject=" + mSubject + ", mContent=" + mContent + ", date=" + date
				+ ", mSender=" + mSender + ", mReceiver=" + mReceiver + "]";
	}
	
	
	
	
	
}
