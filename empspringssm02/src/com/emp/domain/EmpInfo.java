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
 * �û�����ΪԱ���࣬����Ա��������  һ����������е�������Ӧ��Ա�����е��ֶ����Ʊ���һ�¡�
 * @author Administrator
 *
 */
public class EmpInfo {
	//@NotNull(message="Ա����Ų���Ϊ��")
	//@Min(value=1000,message="Ա����ű�����ڵ���1000")
	//@Max(value=9999,message="Ա����ű���С�ڵ���9999")
	@NotNull(message="{empinfo.empno.notnull}",groups={Add.class,Update.class})
	@Min(value=1000,message="{empinfo.empno.min}",groups={Add.class,Update.class})
	@Max(value=9999,message="{empinfo.empno.max}",groups={Add.class,Update.class})
	private Integer empno;
	
	//@NotBlank(message="��������Ϊ��")
	@NotBlank(message="{empinfo.ename.notblank}",groups={Add.class,Update.class,Query.class})
	//@Length(min=1,max=5,message="����ֻ������1-5λ�ַ�")
	@Length(min=1,max=5,message="{empinfo.ename.length}",groups={Add.class,Update.class})
	private String ename;
	
	private String job;
	
	@NotNull(message="��˾��Ų���Ϊ��",groups={Add.class,Update.class})
	private Integer mgr;
	//Ա�����쵼 ��:1(1:1) ������ϵ
	private EmpInfo mgrinfo;
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@NotNull(message="��ְʱ�䲻��Ϊ��",groups={Add.class,Update.class})
	@Past(message="��ְʱ������ǹ�ȥʱ��",groups={Add.class,Update.class})
	private Date hiredate;
	
	@NotNull(message="���ʲ���Ϊ��",groups={Add.class,Update.class})
	private Double sal;
	private Double comm;
	
	@NotNull(message="���ű�Ų���Ϊ��",groups={Add.class,Update.class,Query.class})
	private Integer deptno;
	//�ࣺ1
	private DeptInfo deptinfo;
	
	@NotBlank(message="��¼���Ʋ���Ϊ��",groups={Add.class,Update.class})
	private String loginname;
	
	@NotBlank(message="��¼���벻��Ϊ��",groups={Add.class,Update.class})
	private String loginpwd;
	
	@NotBlank(message="�Ա���Ϊ��",groups={Add.class,Update.class})
	private String sex;
	
	private String enjoy;
	private String[] enjoys;
	
	/*ר�Ŷ����ѯ��������*/
	//private String enamelike;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@NotNull(message="��ʼ��ְʱ�䲻��Ϊ��",groups={Query.class})
	@Past(message="��ʼ��ְʱ������ǹ�ȥʱ��",groups={Query.class})
	private Date startlike;
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@NotNull(message="������ְʱ�䲻��Ϊ��",groups={Query.class})
	@Future(message="������ְʱ������ǽ���ʱ��",groups={Query.class})
	private Date endlike;
	
	private String pagenum;
	private String hiredatestr;
	
	//��ʼ����
	private Integer startNum;
	//��������
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
