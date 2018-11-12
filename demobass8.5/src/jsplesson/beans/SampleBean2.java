package jsplesson.beans;

/**
 * @ClassName: SampleBean2
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月2日 下午7:32:35
 * 
 */
public class SampleBean2 {
    private String id;

    private String age;

    private String name;

    private String sex;

    private String addr;

    public SampleBean2()

    {

    }

    public String getName()

    {

        return name;

    }

    public void setName(String name)

    {

        this.name = name;

    }

    public String getSex()

    {

        return sex;

    }

    public void setSex(String sex)

    {

        this.sex = sex;

    }

    public void setId(String id)

    {

        this.id = id;

    }

    public void setAge(String age)

    {

        this.age = age;

    }

    public String getId()

    {

        return id;

    }

    public String getAge()

    {

        return age;

    }

    public String getAddr()

    {

        return addr;

    }

    public void setAddr(String addr)

    {

        this.addr = addr;

    }

    /**
     * @Title: SampleBean2
     * @param id
     * @param age
     * @param name
     * @param sex
     * @param addr
     */
    public SampleBean2(String id, String age, String name, String sex, String addr) {
        super();
        this.id = id;
        this.age = age;
        this.name = name;
        this.sex = sex;
        this.addr = addr;
    }
}
