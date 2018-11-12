package org.springframework.samples;

/**
 * @ClassName: PnameTest
 * @Description: P命名空间只支持String类型的
 * @date 2018年7月14日 上午11:08:10
 * 
 */
public class PnameTest {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private int num;
    /**
     * @return the driverClassName
     */
    public String getDriverClassName() {
        return driverClassName;
    }
    /**
     * @param driverClassName the driverClassName to set
     */
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }
    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
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
     * @return the num
     */
    public int getNum() {
        return num;
    }
    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }

}
