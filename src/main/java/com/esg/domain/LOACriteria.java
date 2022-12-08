package com.esg.domain;

public class LOACriteria {
	private int page;
    private int perPageNum;
    private String sort;
    
    public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public int getPageStart() {
        return (this.page-1)*perPageNum;
    }
    
    public LOACriteria() {
        this.page = 1;
        this.perPageNum = 10;
    }
    
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        if(page <= 0) {
            this.page = 1;
        } else {
            this.page = page;
        }
    }
    public int getPerPageNum() {
        return perPageNum;
    }
    public void setPerPageNum(int pageCount) {
        int cnt = this.perPageNum;
        if(pageCount != cnt) {
            this.perPageNum = cnt;
        } else {
            this.perPageNum = pageCount;
        }
    }

	@Override
	public String toString() {
		return "LOACriteria [page=" + page + ", perPageNum=" + perPageNum + ", sort=" + sort + "]";
	}
}
