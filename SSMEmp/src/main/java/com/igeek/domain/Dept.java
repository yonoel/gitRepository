package com.igeek.domain;

import javax.persistence.*;

@Table(name = "dept")
public class Dept {
    /**
     * 部门编号
     */
    @Id
    @Column(name = "deptno")
    private Integer deptno;

    /**
     * 部门名称
     */
    @Column(name = "dname")
    private String dname;

    @Column(name = "loc")
    private String loc;

    /**
     * 获取部门编号
     *
     * @return deptno - 部门编号
     */
    public Integer getDeptno() {
        return deptno;
    }

    /**
     * 设置部门编号
     *
     * @param deptno 部门编号
     */
    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    /**
     * 获取部门名称
     *
     * @return dname - 部门名称
     */
    public String getDname() {
        return dname;
    }

    /**
     * 设置部门名称
     *
     * @param dname 部门名称
     */
    public void setDname(String dname) {
        this.dname = dname;
    }

    /**
     * @return loc
     */
    public String getLoc() {
        return loc;
    }

    /**
     * @param loc
     */
    public void setLoc(String loc) {
        this.loc = loc;
    }
}