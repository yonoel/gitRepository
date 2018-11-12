package com.mybatisMapper4.domain;

import javax.persistence.Id;

/**
 * @ClassName: Country
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月20日 上午8:23:38
 * 
 */

public class Country {
    @Id
    private Integer id;
    private String countryname;
    private String countrycode;
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @return the countryname
     */
    public String getCountryname() {
        return countryname;
    }
    /**
     * @param countryname the countryname to set
     */
    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }
    /**
     * @return the countrycode
     */
    public String getCountrycode() {
        return countrycode;
    }
    /**
     * @param countrycode the countrycode to set
     */
    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

}
