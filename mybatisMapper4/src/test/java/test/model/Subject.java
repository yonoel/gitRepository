package test.model;

import javax.persistence.*;

@Table(name = "`subject`")
public class Subject {
    @Id
    @Column(name = "`subno`")
    @GeneratedValue(generator = "JDBC")
    private Integer subno;

    @Column(name = "`sub_type`")
    private String subType;

    @Column(name = "`difficulty`")
    private String difficulty;

    @Column(name = "`sub_content`")
    private String subContent;

    @Column(name = "`optionA`")
    private String optiona;

    @Column(name = "`optionB`")
    private String optionb;

    @Column(name = "`optionC`")
    private String optionc;

    @Column(name = "`optionD`")
    private String optiond;

    @Column(name = "`answer`")
    private String answer;

    @Column(name = "`sub_analysis`")
    private String subAnalysis;

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
     * @return sub_type
     */
    public String getSubType() {
        return subType;
    }

    /**
     * @param subType
     */
    public void setSubType(String subType) {
        this.subType = subType;
    }

    /**
     * @return difficulty
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * @param difficulty
     */
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * @return sub_content
     */
    public String getSubContent() {
        return subContent;
    }

    /**
     * @param subContent
     */
    public void setSubContent(String subContent) {
        this.subContent = subContent;
    }

    /**
     * @return optionA
     */
    public String getOptiona() {
        return optiona;
    }

    /**
     * @param optiona
     */
    public void setOptiona(String optiona) {
        this.optiona = optiona;
    }

    /**
     * @return optionB
     */
    public String getOptionb() {
        return optionb;
    }

    /**
     * @param optionb
     */
    public void setOptionb(String optionb) {
        this.optionb = optionb;
    }

    /**
     * @return optionC
     */
    public String getOptionc() {
        return optionc;
    }

    /**
     * @param optionc
     */
    public void setOptionc(String optionc) {
        this.optionc = optionc;
    }

    /**
     * @return optionD
     */
    public String getOptiond() {
        return optiond;
    }

    /**
     * @param optiond
     */
    public void setOptiond(String optiond) {
        this.optiond = optiond;
    }

    /**
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * @return sub_analysis
     */
    public String getSubAnalysis() {
        return subAnalysis;
    }

    /**
     * @param subAnalysis
     */
    public void setSubAnalysis(String subAnalysis) {
        this.subAnalysis = subAnalysis;
    }
}