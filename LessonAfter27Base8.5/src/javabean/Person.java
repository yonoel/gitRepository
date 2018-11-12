package javabean;

/**
 * @ClassName: Person
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月4日 下午5:48:06
 * 
 */
public class Person {
    private String name;
    private String age;
    private String sex;
    private String home;
    private Address address;
    /**  
    * @Title: Person      
    */
    public Person() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**  
    * @Title: Person  
    * @param name
    * @param age
    * @param sex
    * @param home
    * @param address    
    */
    public Person(String name, String age, String sex, String home, Address address) {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.home = home;
        this.address = address;
    }
    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }
    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
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
     * @return the age
     */
    public String getAge() {
        return age;
    }
    /**
     * @param age the age to set
     */
    public void setAge(String age) {
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
     * @return the home
     */
    public String getHome() {
        return home;
    }
    /**
     * @param home the home to set
     */
    public void setHome(String home) {
        this.home = home;
    }
    /**  
    * @Title: toString  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @return
    * @see java.lang.Object#toString()
    */
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", sex=" + sex + ", home=" + home + "]";
    }
    
}
