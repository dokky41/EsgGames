package com.esg.domain;

import java.sql.Timestamp;

public class esgMileVO {
	// VO

	private String chargeNum;
	private String userid;
	private Timestamp date;
	private String userpoint;
	private String chargeSort;

	public String getChargeNum() {
		return chargeNum;
	}

	public void setChargeNum(String chargeNum) {
		this.chargeNum = chargeNum;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getUserpoint() {
		return userpoint;
	}

	public void setUserpoint(String userpoint) {
		this.userpoint = userpoint;
	}

	public String getChargeSort() {
		return chargeSort;
	}

	public void setChargeSort(String chargeSort) {
		this.chargeSort = chargeSort;
	}

	@Override
	public String toString() {
		return "esgMileVO [chargeNum=" + chargeNum + ", userid=" + userid + ", date=" + date + ", userpoint="
				+ userpoint + ", chargeSort=" + chargeSort + "]";
	}

	
	
	
}
