package com.igeek.domain;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.apache.ibatis.annotations.TypeDiscriminator;
import org.springframework.context.annotation.Conditional;

import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "emp")
public class Emp {
    @Column(name = "COMM")
    private Double comm;

    // @OneToOne(targetEntity = Dept.class, mappedBy =
    // "com.igeek.dao.IDeptMapper.selectByPrimaryKey")
    private Dept dept;

    @Column(name = "DEPTNO")
    private Integer deptno;

    @Id
    @Column(name = "EMPNO")
    @GeneratedValue(generator = "JDBC")
    @NotBlank
    private Integer empno;
    @Column(name = "ENAME")
    private String ename;

    @Column(name = "HIREDATE")
    private Date hiredate;

    @Column(name = "hobbies")
    private String hobbies;

    @Column(name = "JOB")
    private String job;

    @Column(name = "MGR")
  
    private Integer mgr;

    

    @Column(name = "password")
    private Integer password;

    @Column(name = "SAL")
    private Double sal;

    @Column(name = "SEX")
    private String sex;

   

    /**
     * @return COMM
     */
    public Double getComm() {
        return comm;
    }

    /**
     * @return the dept
     */
    public Dept getDept() {
        return dept;
    }

    /**
     * @return DEPTNO
     */
    public Integer getDeptno() {
        return deptno;
    }

    /**
     * @return EMPNO
     */
    public Integer getEmpno() {
        return empno;
    }

    /**
     * @return ENAME
     */
    public String getEname() {
        return ename;
    }

    /**
     * @return HIREDATE
     */
    public Date getHiredate() {
        return hiredate;
    }

    /**
     * @return hobbies
     */
    public String getHobbies() {
        return hobbies;
    }

    /**
     * @return JOB
     */
    public String getJob() {
        return job;
    }

  
    /**
     * @return password
     */
    public Integer getPassword() {
        return password;
    }

    /**
     * @return SAL
     */
    public Double getSal() {
        return sal;
    }

    /**
     * @return SEX
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param comm
     */
    public void setComm(Double comm) {
        this.comm = comm;
    }

    /**
     * @param dept
     *            the dept to set
     */
    public void setDept(Dept dept) {
        this.dept = dept;
    }

    /**
     * @param deptno
     */
    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    /**
     * @param empno
     */
    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    /**
     * @param ename
     */
    public void setEname(String ename) {
        this.ename = ename;
    }

    /**
     * @param hiredate
     */
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    /**
     * @param hobbies
     */
    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    /**
     * @param job
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * @param mgr
     *            the mgr to set
     */
    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

   

    /**
     * @param password
     */
    public void setPassword(Integer password) {
        this.password = password;
    }

    /**
     * @param sal
     */
    public void setSal(Double sal) {
        this.sal = sal;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @Title: toString
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate=" + hiredate
                + ", sal=" + sal + ", comm=" + comm + ", password=" + password + ", deptno=" + deptno + ", sex=" + sex
                + ", hobbies=" + hobbies + "]";
    }
}