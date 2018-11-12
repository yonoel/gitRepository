package test.model;

import javax.persistence.*;

@Table(name = "`sub_paper`")
public class SubPaper {
    @Id
    @Column(name = "`subno`")
    private Integer subno;

    @Id
    @Column(name = "`testno`")
    private Integer testno;

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