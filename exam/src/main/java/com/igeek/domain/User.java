package com.igeek.domain;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "`user`")
public class User implements Serializable{
    /**  
    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)  
    */  
    private static final long serialVersionUID = -75248485477743052L;

    @Id
    @Column(name = "`uid`")
    @GeneratedValue(generator = "JDBC")
    private String uid;

    @Column(name = "`uname`")
    private String uname;

    @Column(name = "`loginuser`")
    private String loginuser;

    @Column(name = "`password`")
    private String password;

    @Column(name = "`sex`")
    private String sex;

    @Column(name = "`age`")
    private Integer age;

    @Column(name = "`roleid`")
    private String roleid;

    /**
     * @return uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return uname
     */
    public String getUname() {
        return uname;
    }

    /**
     * @param uname
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     * @return loginuser
     */
    public String getLoginuser() {
        return loginuser;
    }

    /**
     * @param loginuser
     */
    public void setLoginuser(String loginuser) {
        this.loginuser = loginuser;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return roleid
     */
    public String getRoleid() {
        return roleid;
    }

    /**
     * @param roleid
     */
    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }
}