package org.springframework.samples;

/**  
* @ClassName: Student  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年7月16日 上午8:07:30    
*    
*/
public class Student extends Person{
    private int id;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
