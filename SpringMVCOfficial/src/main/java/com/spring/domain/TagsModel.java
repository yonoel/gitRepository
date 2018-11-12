package com.spring.domain;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: TagsModel
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月10日 上午11:00:16
 * 
 */
public class TagsModel {
    private String username;
    private String password;
    private boolean testBoolean;
    
    private String[] selectArray;
    
    private String[] testArray;
    private Integer radiobuttonId;
    private Integer selectId;
    private List<Integer> selectIds;    
    private Map<Integer,String> testMap;
    private String remark;
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }
    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the testBoolean
     */
    public boolean isTestBoolean() {
        return testBoolean;
    }
    /**
     * @param testBoolean the testBoolean to set
     */
    public void setTestBoolean(boolean testBoolean) {
        this.testBoolean = testBoolean;
    }
    /**
     * @return the selectArray
     */
    public String[] getSelectArray() {
        return selectArray;
    }
    /**
     * @param selectArray the selectArray to set
     */
    public void setSelectArray(String[] selectArray) {
        this.selectArray = selectArray;
    }
    /**
     * @return the testArray
     */
    public String[] getTestArray() {
        return testArray;
    }
    /**
     * @param testArray the testArray to set
     */
    public void setTestArray(String[] testArray) {
        this.testArray = testArray;
    }
    /**
     * @return the radiobuttonId
     */
    public Integer getRadiobuttonId() {
        return radiobuttonId;
    }
    /**
     * @param radiobuttonId the radiobuttonId to set
     */
    public void setRadiobuttonId(Integer radiobuttonId) {
        this.radiobuttonId = radiobuttonId;
    }
    /**
     * @return the selectId
     */
    public Integer getSelectId() {
        return selectId;
    }
    /**
     * @param selectId the selectId to set
     */
    public void setSelectId(Integer selectId) {
        this.selectId = selectId;
    }
    /**
     * @return the selectIds
     */
    public List<Integer> getSelectIds() {
        return selectIds;
    }
    /**
     * @param selectIds the selectIds to set
     */
    public void setSelectIds(List<Integer> selectIds) {
        this.selectIds = selectIds;
    }
    /**
     * @return the testMap
     */
    public Map<Integer, String> getTestMap() {
        return testMap;
    }
    /**
     * @param testMap the testMap to set
     */
    public void setTestMap(Map<Integer, String> testMap) {
        this.testMap = testMap;
    }
    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }
    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }  

}
