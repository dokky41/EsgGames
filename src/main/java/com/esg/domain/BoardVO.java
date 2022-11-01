package com.esg.domain;

import java.sql.Timestamp;

public class BoardVO {
	private String userid; //���ۼ���
	private String boardpw; //�ۻ����� �ʿ��� ��й�ȣ
	private String subject; //������
	private String content; //�۳���
	private int readcount; //����ȸ��
	private Timestamp date; //�� ������¥
	private String ip;//�� �ۼ�ip
	private String file;//�� ÷������
	private int num;//�� ������ȣ

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
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "LOLboardVO [userid=" + userid + ", boardpw=" + boardpw + ", subject=" + subject + ", content=" + content
				+ ", readcount=" + readcount + ", date=" + date + ", ip=" + ip + ", file=" + file + ", num=" + num
				+ "]";
	}
	
	
	
}
