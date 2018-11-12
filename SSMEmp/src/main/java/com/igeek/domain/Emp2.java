package com.igeek.domain;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonView;
import com.igeek.dao.HobbiesTypeHandler;
import com.igeek.dao.SexEnumTypeHandler;

import tk.mybatis.mapper.annotation.ColumnType;

/**
 * @ClassName: Emp
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月16日 下午4:29:15
 * 
 */
@Repository
public class Emp2 {

    @Id
    @Column(name = "EMPNO")
    @GeneratedValue(generator = "JDBC")
    private Integer empNo;
    private Integer password;
    @Column(name = "ename")
    private String empName;
    private String job;
    @ColumnType(jdbcType = JdbcType.VARBINARY, typeHandler = SexEnumTypeHandler.class)
    private SexEnum sex;
    @ColumnType(jdbcType = JdbcType.VARCHAR, typeHandler = HobbiesTypeHandler.class)
    private String[] hobbies;
    private Integer mgr;
    private Date hiredate;
    private double sal;
    private double comm;
    private Integer deptno;

    /**
     * @return the password
     */

    public Integer getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(Integer password) {
        this.password = password;
    }

    /**
     * @Title: Emp
     * @param empNo
     * @param password
     * @param empName
     * @param job
     * @param sex
     * @param hobbies
     * @param mgr
     * @param hiredate
     * @param sal
     * @param comm
     * @param deptno
     */
    public Emp2(Integer empNo, Integer password, String empName, String job, SexEnum sex, String[] hobbies, Integer mgr,
            Date hiredate, double sal, double comm, Integer deptno) {
        super();
        this.empNo = empNo;
        this.password = password;
        this.empName = empName;
        this.job = job;
        this.sex = sex;
        this.hobbies = hobbies;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    /**
     * @return the empNo
     */
    public Integer getEmpNo() {
        return empNo;
    }

    /**
     * @param empNo
     *            the empNo to set
     */
    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    /**
     * @return the empName
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * @param empName
     *            the empName to set
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * @return the job
     */
    public String getJob() {
        return job;
    }

    /**
     * @param job
     *            the job to set
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * @return the sex
     */
    public SexEnum getSex() {
        return sex;
    }

    /**
     * @param sex
     *            the sex to set
     */
    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    /**
     * @return the hobbies
     */
    public String[] getHobbies() {
        return hobbies;
    }

    /**
     * @param hobbies
     *            the hobbies to set
     */
    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    /**
     * @return the hiredate
     */
    public Date getHiredate() {
        return hiredate;
    }

    /**
     * @param hiredate
     *            the hiredate to set
     */
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    /**
     * @return the sal
     */
    public double getSal() {
        return sal;
    }

    /**
     * @param sal
     *            the sal to set
     */
    public void setSal(double sal) {
        this.sal = sal;
    }

    /**
     * @return the comm
     */
    public double getComm() {
        return comm;
    }

    /**
     * @param comm
     *            the comm to set
     */
    public void setComm(double comm) {
        this.comm = comm;
    }

    /**
     * @return the deptno
     */
    public Integer getDeptno() {
        return deptno;
    }

    /**
     * @param deptno
     *            the deptno to set
     */
    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    /**
     * @Title: Emp
     * @param empNo
     * @param empName
     * @param job
     * @param sex
     * @param hobbies
     * @param mgr
     * @param hiredate
     * @param sal
     * @param comm
     * @param deptno
     */
    public Emp2(Integer empNo, String empName, String job, SexEnum sex, String[] hobbies, Integer mgr, Date hiredate,
            double sal, double comm, Integer deptno) {
        super();
        this.empNo = empNo;
        this.empName = empName;
        this.job = job;
        this.sex = sex;
        this.hobbies = hobbies;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    /**
     * @return the mgr
     */
    public Integer getMgr() {
        return mgr;
    }

    /**
     * @param mgr
     *            the mgr to set
     */
    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    /**
     * @Title: Emp
     */
    public Emp2() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @Title: toString
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Emp [empNo=" + empNo + ", empName=" + empName + ", job=" + job + ", sex=" + sex + ", hobbies="
                + Arrays.toString(hobbies) + ", mgr=" + mgr + ", hiredate=" + hiredate + ", sal=" + sal + ", comm="
                + comm + ", deptno=" + deptno + "]";
    }

}
