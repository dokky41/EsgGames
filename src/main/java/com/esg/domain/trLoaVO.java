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
	private String file; // 글 첨부파일
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
		return "trLoaVO [userid=" + userid + ", subject=" + subject + ", goodsCount=" + goodsCount + ", chname="
				+ chname + ", price=" + price + ", content=" + content + ", readcount=" + readcount + ", date=" + date
				+ ", ip=" + ip + ", file=" + file + ", num=" + num + "]";
	}

}
