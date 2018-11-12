package com.igeek.domain;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "`sub_paper`")
public class SubPaper implements Serializable{
    /**  
    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)  
    */  
    private static final long serialVersionUID = -1634667199739983897L;

    @Id
    @Column(name = "`subno`")
    private Integer subno;

    @Id
    @Column(name = "`testno`")
    private Integer testno;

    /**
     * @Title: SubPaper
     * @param subno
     * @param testno
     * @param score
     */
    public SubPaper(Integer subno, Integer testno, Integer score) {
        super();
        this.subno = subno;
        this.testno = testno;
        this.score = score;
    }

    /**  
    * @Title: SubPaper      
    */
    public SubPaper() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Column(name = "`score`")
    private Integer score;

    /**
     * @return subno
     */
    public Integer getSubno() {
        return subno;
    }

    /**
     * @param subno
     */
    public void setSubno(Integer subno) {
        this.subno = subno;
    }

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