package com.spring.domain;

/**  
* @ClassName: User  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年7月11日 上午7:52:09    
*    
*/
public class User {
    private String name;
    private String psd;
    /**  
    * @Title: User      
    */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**  
    * @Title: User  
    * @param name
    * @param psd    
    */
    public User(String name, String psd) {
        super();
        this.name = name;
        this.psd = psd;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the psd
     */
    public String getPsd() {
        return psd;
    }
    /**
     * @param psd the psd to set
     */
    public void setPsd(String psd) {
        this.psd = psd;
    }
}
