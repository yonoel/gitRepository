package com.igeek.mvc.domain;

import org.springframework.stereotype.Repository;

@Repository
public class Category {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.cid
     *
     * @mbg.generated Thu Jul 26 07:23:07 CST 2018
     */
    private String cid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.cname
     *
     * @mbg.generated Thu Jul 26 07:23:07 CST 2018
     */
    private String cname;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.cid
     *
     * @return the value of category.cid
     *
     * @mbg.generated Thu Jul 26 07:23:07 CST 2018
     */
    public String getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.cid
     *
     * @param cid the value for category.cid
     *
     * @mbg.generated Thu Jul 26 07:23:07 CST 2018
     */
    public void setCid(String cid) {
        this.cid = cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.cname
     *
     * @return the value of category.cname
     *
     * @mbg.generated Thu Jul 26 07:23:07 CST 2018
     */
    public String getCname() {
        return cname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.cname
     *
     * @param cname the value for category.cname
     *
     * @mbg.generated Thu Jul 26 07:23:07 CST 2018
     */
    public void setCname(String cname) {
        this.cname = cname;
    }
}