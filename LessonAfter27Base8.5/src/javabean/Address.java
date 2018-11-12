package javabean;

/**  
* @ClassName: Address  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年7月5日 上午8:15:42    
*    
*/
public class Address {
    private String name;

    /**  
    * @Title: Address      
    */
    public Address() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**  
    * @Title: Address  
    * @param name    
    */
    public Address(String name) {
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
}
