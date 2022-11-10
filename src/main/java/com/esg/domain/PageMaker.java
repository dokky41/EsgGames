package com.esg.domain;


	public class PageMaker {
		
		//����¡ ó���� �ʿ��� ��� ������ �����ϴ� ��ü
		
		//��ܺ� ����¡ ó��
		private Criteria cri;
		
		//�ϴܺ� ����¡ ó��
		private int totalCount;
		private int startPage;
		private int endPage;
		private boolean prev;
		private boolean next;
		
		private int displayPageNum = 10; //������ �� ��
		
		public void setCri(Criteria cri) {
			this.cri = cri;
		}
		
		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
			
			calData();
		}
		
		public void calData() {
			
			System.out.println("-----����¡ ó���� �ʿ��� ���� ���");
			
			endPage = (int) (Math.ceil(cri.getPage()/(double)displayPageNum) * displayPageNum);
			
			startPage = (endPage - displayPageNum) + 1;
			
			int tmpEndPage = (int) (Math.ceil(totalCount/(double)cri.getPerPageNum()));
			
			if(endPage > tmpEndPage) {
				endPage = tmpEndPage;
			}
			
			prev = startPage == 1? false : true;
			
			next = endPage * cri.getPerPageNum() >= totalCount? false : true;
			
			System.out.println("�ϴ� ����¡ ó���� �ʿ��� ���� ��� �Ϸ�.");
		}

		public int getStartPage() {
			return startPage;
		}

		public void setStartPage(int startPage) {
			this.startPage = startPage;
		}

		public int getEndPage() {
			return endPage;
		}

		public void setEndPage(int endPage) {
			this.endPage = endPage;
		}

		public boolean isPrev() {
			return prev;
		}

		public void setPrev(boolean prev) {
			this.prev = prev;
		}

		public boolean isNext() {
			return next;
		}

		public void setNext(boolean next) {
			this.next = next;
		}

		public int getDisplayPageNum() {
			return displayPageNum;
		}

		public void setDisplayPageNum(int displayPageNum) {
			this.displayPageNum = displayPageNum;
		}

		public Criteria getCri() {
			return cri;
		}

		public int getTotalCount() {
			return totalCount;
		}

		@Override
		public String toString() {
			return "PageMaker [cri=" + cri + ", totalCount=" + totalCount + ", startPage=" + startPage + ", endPage="
					+ endPage + ", prev=" + prev + ", next=" + next + ", displayPageNum=" + displayPageNum + "]";
		}

	
}
