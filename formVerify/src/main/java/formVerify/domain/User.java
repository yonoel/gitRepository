package formVerify.domain;

import java.util.Date;

/**
 * @ClassName: User
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月3日 上午8:00:32
 * 
 */
public class User {
    private String id;
    private String userName;
    private Integer userPwd;
    private String email;
    private Date birthday;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userPwd
     */
    public Integer getUserPwd() {
        return userPwd;
    }

    /**
     * @param userPwd
     *            the userPwd to set
     */
    public void setUserPwd(Integer userPwd) {
        this.userPwd = userPwd;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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

    /**
     * @Title: toString
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", userPwd=" + userPwd + ", email=" + email + ", birthday="
                + birthday + "]";
    }

    /**
     * @Title: User
     * @param id
     * @param userName
     * @param userPwd
     * @param email
     * @param birthday
     */
    public User(String id, String userName, Integer userPwd, String email, Date birthday) {
        super();
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.email = email;
        this.birthday = birthday;
    }

    /**
     * @Title: User
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

}
