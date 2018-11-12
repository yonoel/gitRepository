package study.domain;

/**
 * @ClassName: Child
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月8日 上午10:54:54
 * 
 */
public class Child extends Father {
    private String id;

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    private String name;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    private Integer age;

    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     *            the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}
