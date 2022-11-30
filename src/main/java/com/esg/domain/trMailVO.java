package com.esg.domain;

import java.sql.Timestamp;

public class trMailVO {

		private int trBnum;
		private String trSender;
		private String trReceiver;
		private String gNickName;
		private int trCount;
		private String trSubject;
		private String trContent;
		private Timestamp trDate;
		private Timestamp trUpDate;
		private String trState;
		private int trConNum;
		
		public int getTrBnum() {
			return trBnum;
		}
		public void setTrBnum(int trBnum) {
			this.trBnum = trBnum;
		}
		public String getTrSender() {
			return trSender;
		}
		public void setTrSender(String trSender) {
			this.trSender = trSender;
		}
		public String getTrReceiver() {
			return trReceiver;
		}
		public void setTrReceiver(String trReceiver) {
			this.trReceiver = trReceiver;
		}
		public String getgNickName() {
			return gNickName;
		}
		public void setgNickName(String gNickName) {
			this.gNickName = gNickName;
		}
		public int getTrCount() {
			return trCount;
		}
		public void setTrCount(int trCount) {
			this.trCount = trCount;
		}
		public String getTrSubject() {
			return trSubject;
		}
		public void setTrSubject(String trSubject) {
			this.trSubject = trSubject;
		}
		public String getTrContent() {
			return trContent;
		}
		public void setTrContent(String trContent) {
			this.trContent = trContent;
		}
		public Timestamp getTrDate() {
			return trDate;
		}
		public void setTrDate(Timestamp trDate) {
			this.trDate = trDate;
		}
		public Timestamp getTrUpDate() {
			return trUpDate;
		}
		public void setTrUpDate(Timestamp trUpDate) {
			this.trUpDate = trUpDate;
		}
		public String getTrState() {
			return trState;
		}
		public void setTrState(String trState) {
			this.trState = trState;
		}
		public int getTrConNum() {
			return trConNum;
		}
		public void setTrConNum(int trConNum) {
			this.trConNum = trConNum;
		}
		@Override
		public String toString() {
			return "trMailVO [trBnum=" + trBnum + ", trSender=" + trSender + ", trReceiver=" + trReceiver
					+ ", gNickName=" + gNickName + ", trCount=" + trCount + ", trSubject=" + trSubject + ", trContent="
					+ trContent + ", trDate=" + trDate + ", trUpDate=" + trUpDate + ", trState=" + trState
					+ ", trConNum=" + trConNum + "]";
		}
		
		
		
		
		
		
}
