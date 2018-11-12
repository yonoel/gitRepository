package com.emp.util;

import com.emp.constant.ConstantMethod;

public class PageInfo {
	//总记录
	private int dataCount;
	//访问的页数
	private int pageNum;
	//每页显示的条数
	private int pageSize;
	//总页数
	private int pageCount;
	//开始索引
	private int startNum;
	//结束索引
	private int endNum;
	public int getDataCount() {
		return dataCount;
	}
	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	public PageInfo(int dataCount, int pageNum) {
		super();
		this.dataCount = dataCount;
		this.pageNum = pageNum;
		this.pageSize = ConstantMethod.pageSize;
		//取得总页数
		getPC();
		//开始下标和结束下标
		getIndex();
	}
	
	public void getPC(){
		//取得总页数
		if(dataCount%pageSize == 0){
			pageCount = dataCount/pageSize;
		}else {
			pageCount = dataCount/pageSize+1;
		}
	}
	
	public void getIndex(){
		startNum = (pageNum-1)*pageSize+1;
		endNum = pageNum*pageSize;
	}
	
	
	
	
}
