package jsplesson.beans;

import java.util.Date;

/**  
* @ClassName: Person  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年7月2日 下午6:41:48    
*    
*/
public class Person {
   
    private Date birthday;
    /**  
    * @Title: Person  
    * @param birthday
    * @param name
    * @param age
    * @param sex
    * @param married    
    */
    public Person(Date birthday, String name, int age, String sex, boolean married) {
        super();
        this.birthday = birthday;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.married = married;
    }
    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }
    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    private String name;
   
    /**  
    * @Title: Person      
    */
    public Person() {
        super();
        // TODO Auto-generated constructor stub
    }
    private int age;
    private String sex;
    private boolean married;
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
     * @return the age
     */
    public int getAge() {
        return age;
    }
    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }
    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
    /**
     * @return the married
     */
    public boolean isMarried() {
        return married;
    }
    /**
     * @param married the married to set
     */
    public void setMarried(boolean married) {
        this.married = married;
    }
    /**  
    * @Title: Person  
    * @param name
    * @param age
    * @param sex
    * @param married    
    */
    public Person(String name, int age, String sex, boolean married) {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.married = married;
    }
    
    
}
