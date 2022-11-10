package com.esg.domain;

public class Criteria {

	//����¡ ó���� ���� �ҽ� ����
	
	private int page; //������ ���۹�ȣ
	private int perPageNum; //������ ũ��
	private String searchName; //������ ũ��
	
	public Criteria() {
		
		System.out.println("-------------------�⺻������ (1������ 10����) ----------");
		this.page=1;
		this.perPageNum=10;
		
	}
	
	public void setPage(int page) {
		
		System.out.println("-----------setPage(page) +" +page+ "----------");
		if(page <= 0) {
			
			this.page=1;
			return;
			
		}
		this.page = page;
		
	}
	
	
	public void setPerPageNum(int perPageNum) {
		
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		
		
	}
	
	//mapper���� ���� �޼���
	public int getPageStart() {
		System.out.println("---------getPageStart()----");
		return (this.page -1) * perPageNum;
		
	}
	
	public int getPerPageNum() {
		System.out.println("-----------getPerPageNum() ---------");
		return perPageNum;
		
	}
	
	public int getPage() {
		return page;
	}

	
	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	

}