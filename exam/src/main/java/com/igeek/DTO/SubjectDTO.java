package com.igeek.DTO;

import javax.persistence.Column;
import javax.persistence.Transient;

import com.igeek.domain.Subject;

/**
 * @ClassName: SubjectDTO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月8日 上午10:46:47
 * 
 */

public class SubjectDTO extends Subject {
    @Transient
    private Integer subjectnum;
    @Column(name = "score")
    private Integer score;
    @Transient
    private String type;

    /**
     * @return the subjectnum
     */
    public Integer getSubjectnum() {
        return subjectnum;
    }

    /**
     * @param subjectnum
     *            the subjectnum to set
     */
    public void setSubjectnum(Integer subjectnum) {
        this.subjectnum = subjectnum;
    }

    /**
     * @return the score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score
     *            the score to set
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    @Transient
    private String diff;

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType() {
        String type = "";
        if ("1".equals(this.getSubType())) {
            type = "单选";
        } else if ("2".equals(this.getSubType())) {
            type = "多选";
        } else if ("3".equals(this.getSubType())) {
            type = "判断";
        } else if ("4".equals(this.getSubType())) {
            type = "问答";
        } else {
            type = "没设";
        }
        this.type = type;
    }

    /**
     * @return the diff
     */
    public String getDiff() {
        return diff;
    }

    /**
     * @param diff
     *            the diff to set
     */
    public void setDiff() {
        String diff = "";
        if ("1".equals(this.getDifficulty())) {
            diff = "容易";
        } else if ("2".equals(this.getDifficulty())) {
            diff = "一般";
        } else if ("3".equals(this.getDifficulty())) {
            diff = "困难";
        } else {
            diff = "没设";
        }
        this.diff = diff;
    }

    /**
     * @Title: toString
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SubjectDTO [subjectnum=" + subjectnum + ", score=" + score + ", type=" + type + ", diff=" + diff
                + ", toString()=" + super.toString() + "]";
    }
    
}
