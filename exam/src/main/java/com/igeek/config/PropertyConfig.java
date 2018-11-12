package com.igeek.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @ClassName: PropertyConfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月3日 下午4:36:32
 * 
 */
@ComponentScan
@Configuration
@Qualifier("propertyConfig")
public class PropertyConfig {
   
    @Value("${spring.datasource.driver}")
    private String driver;

    @Autowired
    private Environment environment;
    @Value("${spring.datasource.initialSize}")
    private Integer initialSize;
    @Value("${spring.datasource.maxActive}")
    private Integer maxActive;
    @Value("${spring.datasource.maxIdle}")
    private Integer maxIdle;
    @Value("${mybatis.basePackage}")
    private String mybatisTypeAliasPackage;
    @Value("${spring.datasource.password}")
    private String password;
    
    @Value("${redis.maxIdle}")
    private Integer redisMaxIdle;
    
//    @Value("${redis.minIdle}")
    private Integer redisMinIdle;
//    @Value("${redis.maxTotal}")
    private Integer redisMaxTotal;
    @Value("${redis.host}")
    private String redisHost;
    @Value("${redis.port}")
    private Integer redisPort;
    /**
     * @return the redisMinIdle
     */
    public Integer getRedisMinIdle() {
        return redisMinIdle;
    }

    /**
     * @param redisMinIdle the redisMinIdle to set
     */
    public void setRedisMinIdle(Integer redisMinIdle) {
        this.redisMinIdle = redisMinIdle;
    }

    /**
     * @return the redisMaxTotal
     */
    public Integer getRedisMaxTotal() {
        return redisMaxTotal;
    }

    /**
     * @param redisMaxTotal the redisMaxTotal to set
     */
    public void setRedisMaxTotal(Integer redisMaxTotal) {
        this.redisMaxTotal = redisMaxTotal;
    }

   

    /**
     * @return the redisHost
     */
    public String getRedisHost() {
        return redisHost;
    }

    /**
     * @param redisHost the redisHost to set
     */
    public void setRedisHost(String redisHost) {
        this.redisHost = redisHost;
    }

    /**
     * @return the redisPort
     */
    public Integer getRedisPort() {
        return redisPort;
    }

    /**
     * @param redisPort the redisPort to set
     */
    public void setRedisPort(Integer redisPort) {
        this.redisPort = redisPort;
    }

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.user}")
    private String user;

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @return the environment
     */
    public Environment getEnvironment() {
        return environment;
    }

    /**
     * @return the initialSize
     */
    public Integer getInitialSize() {
        return initialSize;
    }

    /**
     * @return the maxActive
     */
    public Integer getMaxActive() {
        return maxActive;
    }

    /**
     * @return the maxIdle
     */
    public Integer getMaxIdle() {
        return maxIdle;
    }

    /**
     * @return the mybatisTypeAliasPackage
     */
    public String getMybatisTypeAliasPackage() {
        return mybatisTypeAliasPackage;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**  
    * @Title: getRedisMaxIdle  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @return    
    */
    public Integer getRedisMaxIdle() {
        // TODO Auto-generated method stub
        return redisMaxIdle;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param driver
     *            the driver to set
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * @param environment the environment to set
     */
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /**
     * @param initialSize
     *            the initialSize to set
     */
    public void setInitialSize(Integer initialSize) {
        this.initialSize = initialSize;
    }

    /**
     * @param maxActive
     *            the maxActive to set
     */
    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }

    /**
     * @param maxIdle
     *            the maxIdle to set
     */
    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    /**
     * @param mybatisTypeAliasPackage
     *            the mybatisTypeAliasPackage to set
     */
    public void setMybatisTypeAliasPackage(String mybatisTypeAliasPackage) {
        this.mybatisTypeAliasPackage = mybatisTypeAliasPackage;
    }
    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @param redisMaxIdle the redisMaxIdle to set
     */
    public void setRedisMaxIdle(Integer redisMaxIdle) {
        this.redisMaxIdle = redisMaxIdle;
    }

    /**
     * @param url
     *            the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @param user
     *            the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @Title: toString
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PropertyConfig [url=" + url + ", driver=" + driver + ", user=" + user + ", password=" + password
                + ", initialSize=" + initialSize + ", maxActive=" + maxActive + ", maxIdle=" + maxIdle
                + ", mybatisTypeAliasPackage=" + mybatisTypeAliasPackage + "]";
    }
}
