package com.emp.domain;

public class DeptInfo {
	private Integer deptno;
	private String dname;
	private String loc;
	//集合关系  部门：员工  1：多
	//private List<EmpInfo> emplist;
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public DeptInfo(Integer deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	public DeptInfo() {
		super();
	}
	
	
	
}
