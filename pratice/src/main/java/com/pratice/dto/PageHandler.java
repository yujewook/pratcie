package com.pratice.dto;

public class PageHandler {
	private int totalCount ;
	private int pageSize;
	private int offset;
	private int naviSize = 10;
	private int totalPage;
	private int page;
	private int beginPage;
	private int endPage;
	private boolean showPrev;
	private boolean showNext;
	
	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getNaviSize() {
		return naviSize;
	}


	public void setNaviSize(int naviSize) {
		this.naviSize = naviSize;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getBeginPage() {
		return beginPage;
	}


	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public boolean isShowPrev() {
		return showPrev;
	}


	public void setShowPrev(boolean showPrev) {
		this.showPrev = showPrev;
	}


	public boolean isShowNext() {
		return showNext;
	}


	public void setShowNext(boolean showNext) {
		this.showNext = showNext;
	}


	
	public PageHandler(int totalCount, int page) {
		this(totalCount,page,10);
	}
	
	public PageHandler() {
		
	}
	
	public PageHandler(int totalCount, int page,int pageSize ) {
		this.totalCount = totalCount;
		this.page = page;
		this.pageSize = pageSize;
		
		totalPage = (int) Math.ceil(totalCount/pageSize);
		//1일의 자리 지우는 방법 -> (x / 10) *10 -> x의 일의자리 없어짐  
		beginPage = page/ naviSize * naviSize*10;
		endPage = Math.min(beginPage+naviSize-1, totalPage);
		showPrev = beginPage !=1;
		showNext = endPage != totalPage;
	}
	
	void print() {
		System.out.println("page = " + page);
	}
	
}
