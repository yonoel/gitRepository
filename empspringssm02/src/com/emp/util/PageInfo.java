package com.emp.util;

import com.emp.constant.ConstantMethod;

public class PageInfo {
	//�ܼ�¼
	private int dataCount;
	//���ʵ�ҳ��
	private int pageNum;
	//ÿҳ��ʾ������
	private int pageSize;
	//��ҳ��
	private int pageCount;
	//��ʼ����
	private int startNum;
	//��������
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
		//ȡ����ҳ��
		getPC();
		//��ʼ�±�ͽ����±�
		getIndex();
	}
	
	public void getPC(){
		//ȡ����ҳ��
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
