package com.esg.domain;

import java.sql.Timestamp;

public class MemberVO {
	//VO
	
	private String userid;
	private String userpw;
	private String username;
	private String useremail;
	private String address;
	private Timestamp regdate;
	private Timestamp updatedate;
	private int userpoint;
	private String phNum;
	private int dayBirth1;
	private int dayBirth2;
	
	
	// alt + shift + s => r
		// getter, setter 찾아보기
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public Timestamp getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}
	public int getUserpoint() {
		return userpoint;
	}
	public void setUserpoint(int userpoint) {
		this.userpoint = userpoint;
	}
	
	public String getPhNum() {
		return phNum;
	}
	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}
	public int getDayBirth1() {
		return dayBirth1;
	}
	public void setDayBirth1(int dayBirth1) {
		this.dayBirth1 = dayBirth1;
	}
	public int getDayBirth2() {
		return dayBirth2;
	}
	public void setDayBirth2(int dayBirth2) {
		this.dayBirth2 = dayBirth2;
	}
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", useremail="
				+ useremail + ", address=" + address + ", regdate=" + regdate + ", updatedate=" + updatedate
				+ ", userpoint=" + userpoint + ", phNum=" + phNum + ", dayBirth1=" + dayBirth1 + ", dayBirth2="
				+ dayBirth2 + "]";
	}
	
	
	
	
		
}

