package org.springframework.samples;

/**  
* @ClassName: Person  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年7月14日 下午12:19:44    
*    
*/
public class Person {
    private String name;
    private Person spouse;
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
     * @return the spouse
     */
    public Person getSpouse() {
        return spouse;
    }
    /**
     * @param spouse the spouse to set
     */
    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }
}
