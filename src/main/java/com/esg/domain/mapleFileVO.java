package com.esg.domain;

public class mapleFileVO {
	private int seq;
	private int fseq;
	private String originalfilename;
	private String filepath;
	private long filesize;
	public int getseq() {
		return seq;
	}
	public void setseq(int seq) {
		this.seq = seq;
	}
	public int setfseq() {
		return fseq;
	}
	public void setfseq(int fseq) {
		this.fseq = fseq;
	}
	public String getoriginalfilename() {
		return originalfilename;
	}
	public void setoriginalfilename(String originalfilename) {
		this.originalfilename = originalfilename;
	}
	public String getFilePath() {
		return filepath;
	}
	public void setfilepath(String filepath) {
		this.filepath = filepath;
	}
	public long getfilesize() {
		return filesize;
	}
	public void setfilesize(long filesize) {
		this.filesize = filesize;
	}
	
	@Override
	public String toString() {
		return "maplefileVO [seq=" + seq + ", fseq=" + fseq + ", orignalfilename=" + originalfilename + ", filepath=" + filepath
				+ ", filesize=" + filesize + "]";
	}
	

}
