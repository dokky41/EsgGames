package com.esg.domain;

import java.sql.Timestamp;

public class trLoaVO {

	private String userid; // 작성자 아이디
	private String subject; // 상품이름
	private String goodsCount; // 상품개수
	private String chname; // 캐릭터명
	private String price; // 판매금액
	private String content; // 글내용
	private int readcount; // 글 조회수
	private Timestamp date; // 글 생성날짜
	private String ip; // 글 작성ip
	private String file1; // 글 첨부파일1
	private String file2; // 글 첨부파일2
	private String file3; // 글 첨부파일3
	private String file4; // 글 첨부파일4
	private int num; // 글 고유번호
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(String goodsCount) {
		this.goodsCount = goodsCount;
	}
	public String getChname() {
		return chname;
	}
	public void setChname(String chname) {
		this.chname = chname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
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
	public String getFile1() {
		return file1;
	}
	public void setFile1(String file1) {
		this.file1 = file1;
	}
	public String getFile2() {
		return file2;
	}
	public void setFile2(String file2) {
		this.file2 = file2;
	}
	public String getFile3() {
		return file3;
	}
	public void setFile3(String file3) {
		this.file3 = file3;
	}
	public String getFile4() {
		return file4;
	}
	public void setFile4(String file4) {
		this.file4 = file4;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "trLoaVO [userid=" + userid + ", subject=" + subject + ", goodsCount=" + goodsCount + ", chname="
				+ chname + ", price=" + price + ", content=" + content + ", readcount=" + readcount + ", date=" + date
				+ ", ip=" + ip + ", file1=" + file1 + ", file2=" + file2 + ", file3=" + file3 + ", file4=" + file4
				+ ", num=" + num + "]";
	}

	
}
