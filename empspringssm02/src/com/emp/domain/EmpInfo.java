package com.emp.domain;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.emp.groups.EmpGroup.Add;
import com.emp.groups.EmpGroup.Query;
import com.emp.groups.EmpGroup.Update;

/**
 * 该基础类为员工类，根据员工表创建的  一般情况下类中的属性名应与员工表中的字段名称保持一致。
 * @author Administrator
 *
 */
public class EmpInfo {
	//@NotNull(message="员工编号不能为空")
	//@Min(value=1000,message="员工编号必须大于等于1000")
	//@Max(value=9999,message="员工编号必须小于等于9999")
	@NotNull(message="{empinfo.empno.notnull}",groups={Add.class,Update.class})
	@Min(value=1000,message="{empinfo.empno.min}",groups={Add.class,Update.class})
	@Max(value=9999,message="{empinfo.empno.max}",groups={Add.class,Update.class})
	private Integer empno;
	
	//@NotBlank(message="姓名不能为空")
	@NotBlank(message="{empinfo.ename.notblank}",groups={Add.class,Update.class,Query.class})
	//@Length(min=1,max=5,message="姓名只能输入1-5位字符")
	@Length(min=1,max=5,message="{empinfo.ename.length}",groups={Add.class,Update.class})
	private String ename;
	
	private String job;
	
	@NotNull(message="上司编号不能为空",groups={Add.class,Update.class})
	private Integer mgr;
	//员工与领导 多:1(1:1) 关联关系
	private EmpInfo mgrinfo;
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@NotNull(message="入职时间不能为空",groups={Add.class,Update.class})
	@Past(message="入职时间必须是过去时间",groups={Add.class,Update.class})
	private Date hiredate;
	
	@NotNull(message="工资不能为空",groups={Add.class,Update.class})
	private Double sal;
	private Double comm;
	
	@NotNull(message="部门编号不能为空",groups={Add.class,Update.class,Query.class})
	private Integer deptno;
	//多：1
	private DeptInfo deptinfo;
	
	@NotBlank(message="登录名称不能为空",groups={Add.class,Update.class})
	private String loginname;
	
	@NotBlank(message="登录密码不能为空",groups={Add.class,Update.class})
	private String loginpwd;
	
	@NotBlank(message="性别不能为空",groups={Add.class,Update.class})
	private String sex;
	
	private String enjoy;
	private String[] enjoys;
	
	/*专门定义查询条件属性*/
	//private String enamelike;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@NotNull(message="开始入职时间不能为空",groups={Query.class})
	@Past(message="开始入职时间必须是过去时间",groups={Query.class})
	private Date startlike;
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@NotNull(message="结束入职时间不能为空",groups={Query.class})
	@Future(message="结束入职时间必须是将来时间",groups={Query.class})
	private Date endlike;
	
	private String pagenum;
	private String hiredatestr;
	
	//开始索引
	private Integer startNum;
	//结束索引
	private Integer endNum;
	
	private Date insertdate;
	
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Integer getMgr() {
		return mgr;
	}
	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public Double getComm() {
		return comm;
	}
	public void setComm(Double comm) {
		this.comm = comm;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}	
	
	public Date getStartlike() {
		return startlike;
	}
	public void setStartlike(Date startlike) {
		this.startlike = startlike;
	}
	public Date getEndlike() {
		return endlike;
	}
	public void setEndlike(Date endlike) {
		this.endlike = endlike;
	}
	
	
	
	
	
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getLoginpwd() {
		return loginpwd;
	}
	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}
	
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEnjoy() {
		return enjoy;
	}
	public void setEnjoy(String enjoy) {
		this.enjoy = enjoy;
	}
	
	
	public String getPagenum() {
		return pagenum;
	}
	public void setPagenum(String pagenum) {
		this.pagenum = pagenum;
	}
	
	
	public String getHiredatestr() {
		return hiredatestr;
	}
	public void setHiredatestr(String hiredatestr) {
		this.hiredatestr = hiredatestr;
	}
	
	public String[] getEnjoys() {
		return enjoys;
	}
	public void setEnjoys(String[] enjoys) {
		this.enjoys = enjoys;
	}
	
	
	public Integer getStartNum() {
		return startNum;
	}
	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}
	public Integer getEndNum() {
		return endNum;
	}
	public void setEndNum(Integer endNum) {
		this.endNum = endNum;
	}
	
	
	public EmpInfo getMgrinfo() {
		return mgrinfo;
	}
	public void setMgrinfo(EmpInfo mgrinfo) {
		this.mgrinfo = mgrinfo;
	}
	public DeptInfo getDeptinfo() {
		return deptinfo;
	}
	public void setDeptinfo(DeptInfo deptinfo) {
		this.deptinfo = deptinfo;
	}
	
	
	
	public Date getInsertdate() {
		return insertdate;
	}
	public void setInsertdate(Date insertdate) {
		this.insertdate = insertdate;
	}
	public EmpInfo(Integer empno, String ename, String job, Integer mgr,
			Date hiredate, Double sal, Double comm, Integer deptno,
			String loginname, String loginpwd, String sex, String enjoy) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
		this.loginname = loginname;
		this.loginpwd = loginpwd;
		this.sex = sex;
		this.enjoy = enjoy;
	}
	public EmpInfo() {
		super();
	}
}
