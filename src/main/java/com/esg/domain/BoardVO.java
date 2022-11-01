package com.esg.domain;

import java.sql.Timestamp;

public class BoardVO {
	private String userid; //글작성자
	private String boardpw; //글삭제시 필요한 비밀번호
	private String subject; //글제목
	private String content; //글내용
	private int readcount; //글조회수
	private Timestamp date; //글 생성날짜
	private String ip;//글 작성ip
	private String file;//글 첨부파일
	private int num;//글 고유번호

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
