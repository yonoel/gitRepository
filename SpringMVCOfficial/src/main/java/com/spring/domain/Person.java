package com.spring.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @ClassName: Person
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月9日 下午4:06:12
 * 
 */
public class Person {
    // 测试json view
    public interface WithoutPasswordView {
    }

    public interface WithPasswordView extends WithoutPasswordView {
    }

    private Date birthday;

    private String hobbies;

    private long id;

    private String name;

    /**
     * @Title: Person
     */
    public Person() {
        super();
        // TODO Auto-generated constructor stub
    };

    /**
     * @Title: Person
     * @param id
     */
    public Person(long id) {
        super();
        this.id = id;
    };

    /**
     * @Title: Person
     * @param name
     * @param id
     */
    public Person(String name, long id) {
        super();
        this.name = name;
        this.id = id;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @return the hobbies
     */
    public String getHobbies() {
        return hobbies;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    @JsonView(WithoutPasswordView.class)
    public String getPersonName() {
        return this.getName();
    }

    @JsonView(WithPasswordView.class)
    public Long getPersonPassword() {
        return this.getId();
    }

    /**
     * @param birthday
     *            the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @param hobbies the hobbies to set
     */
    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
