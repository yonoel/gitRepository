package com.example.SpringBootStudy.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "`testpaper`")
public class Testpaper implements Serializable {
    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = -7888978238338039658L;

    @Id
    @Column(name = "`testno`")
    @GeneratedValue(generator = "JDBC")
    private Integer testno;

    @Column(name = "`testname`")
    private String testname;

    @Column(name = "`tstart`")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date tstart;

    @Column(name = "`tend`")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date tend;

    @Column(name = "`testtime`")
    private Integer testtime;

    @Column(name = "`announcetime`")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date announcetime;

    @Column(name = "`score`")
    private Integer score;

    /**
     * @return testno
     */
    public Integer getTestno() {
        return testno;
    }

    /**
     * @param testno
     */
    public void setTestno(Integer testno) {
        this.testno = testno;
    }

    /**
     * @return testname
     */
    public String getTestname() {
        return testname;
    }

    /**
     * @param testname
     */
    public void setTestname(String testname) {
        this.testname = testname;
    }

    /**
     * @return tstart
     */
    public Date getTstart() {
        return tstart;
    }

    /**
     * @param tstart
     */
    public void setTstart(Date tstart) {
        this.tstart = tstart;
    }

    /**
     * @return tend
     */
    public Date getTend() {
        return tend;
    }

    /**
     * @param tend
     */
    public void setTend(Date tend) {
        this.tend = tend;
    }

    /**
     * @return testtime
     */
    public Integer getTesttime() {
        return testtime;
    }

    /**
     * @param testtime
     */
    public void setTesttime(Integer testtime) {
        this.testtime = testtime;
    }

    /**
     * @return announcetime
     */
    public Date getAnnouncetime() {
        return announcetime;
    }

    /**
     * @param announcetime
     */
    public void setAnnouncetime(Date announcetime) {
        this.announcetime = announcetime;
    }

    /**
     * @return score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Integer score) {
        this.score = score;
    }
}