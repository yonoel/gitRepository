package study.domain;

/**  
* @ClassName: User  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年7月19日 上午8:05:04    
*    
*/
public class User {
    private String name;

    /**  
    * @Title: User  
    * @param name    
    */
    public User(String name) {
        super();
        this.name = name;
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
    * @Title: User      
    */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
}
