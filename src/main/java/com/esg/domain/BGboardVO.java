package com.esg.domain;

import java.sql.Timestamp;

public class BGboardVO {
	
	private String userid;
	private String boardpw; 
	private String subject; 
	private String content; 
	private int readcount; 
	private Timestamp date; 
	private String ip; 
	private int num; 
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getBoardpw() {
		return boardpw;
	}
	public void setBoardpw(String boardpw) {
		this.boardpw = boardpw;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "BGboardVO [userid=" + userid + ", boardpw=" + boardpw + ", subject=" + subject + ", content=" + content
				+ ", readcount=" + readcount + ", date=" + date + ", ip=" + ip + ", num=" + num
				+ "]";
	}

}
