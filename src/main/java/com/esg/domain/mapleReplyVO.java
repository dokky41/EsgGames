package com.esg.domain;

import java.sql.Timestamp;

public class mapleReplyVO {
	 private int reply_no;
	    private int article_no;
	    private String reply_text;
	    private String reply_writer;
	    private Timestamp reg_date;
	    private Timestamp update_date;

	    public int getreply_no() {
	    	return reply_no;
	    }
	    public void setreply_no(int reply_no) {
	    	reply_no = reply_no;
	    }
	    public int getarticle_no() {
	    	return article_no;
	    }
	    public void setarticle_no(int article_no) {
	    	article_no = article_no;
	    }
	    public String getreply_text() {
	    	return reply_text;
	    }
	    public void setreply_text(String reply_text) {
	    	reply_text = reply_text;
	    }
	    public String getreply_writer() {
	    	return reply_writer;
	    }
	    public void setreply_writer(String reply_writer) {
	    	reply_writer = reply_writer;
	    }
	    public Timestamp getreg_date() {
			return reg_date;
		}
		public void setreg_date(Timestamp reg_date) {
			reg_date = reg_date;
		}
		 public Timestamp update_date() {
			return update_date;
		}
		public void setupdate_date(Timestamp update_date) {
			update_date = update_date;
		}
	    
	    @Override
	    public String toString() {
	      return "mapleReplyVO [reply_no=" + reply_no + 
	                    ", article_no="+ article_no + 
	                    ", reply_text="+ reply_text + 
	                    ", reply_writer="+ reply_writer + 
	                    ", reg_date="+ reg_date + 
	                    ", update_date="+ update_date+ "]" ;
	    }

}
