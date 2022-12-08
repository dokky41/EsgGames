package com.esg.domain;

public class esgChange {

	private int exChNum;
	private String userid;
	private int userpoint;
	private String username;
	private String chargeNum;
	private String state;
	public int getExChNum() {
		return exChNum;
	}
	public void setExChNum(int exChNum) {
		this.exChNum = exChNum;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getUserpoint() {
		return userpoint;
	}
	public void setUserpoint(int userpoint) {
		this.userpoint = userpoint;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getChargeNum() {
		return chargeNum;
	}
	public void setChargeNum(String chargeNum) {
		this.chargeNum = chargeNum;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "esgChange [exChNum=" + exChNum + ", userid=" + userid + ", userpoint=" + userpoint + ", username="
				+ username + ", chargeNum=" + chargeNum + ", state=" + state + "]";
	}
	
	
	
	
}
