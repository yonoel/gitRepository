package atmsystem.spring.domain;

import java.util.Date;

/**
 * @ClassName: Account
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月11日 下午5:48:23
 * 
 */
public class Account {

    private String name;
    private Integer id;

    /**
     * @Title: Account
     * @param name
     * @param id
     * @param password
     * @param cash
     * @param birthday
     */
    public Account(String name, Integer id, Integer password, double cash, Date birthday) {
        super();
        this.name = name;
        this.id = id;
        this.password = password;
        this.cash = cash;
        this.birthday = birthday;
    }

    /**
     * @Title: toString
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Account [name=" + name + ", id=" + id + ", password=" + password + ", cash=" + cash + ", birthday="
                + birthday + "]";
    }

    /**
     * @Title: Account
     */
    public Account() {
        super();
        // TODO Auto-generated constructor stub
    }

    private Integer password;
    private double cash;
    private Date birthday;

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

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the password
     */
    public Integer getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(Integer password) {
        this.password = password;
    }

    /**
     * @return the cash
     */
    public double getCash() {
        return cash;
    }

    /**
     * @param cash
     *            the cash to set
     */
    public void setCash(double cash) {
        this.cash = cash;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     *            the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
