package javabean;

/**
 * @ClassName: User
 * @Description: TODO(������һ�仰��������������)
 * @date 2018��7��5�� ����8:35:38
 * 
 */
public class User {
    private String name;
    private String psd;

    /**
     * @return the psd
     */
    public String getPsd() {
        return psd;
    }

    /**
     * @param psd
     *            the psd to set
     */
    public void setPsd(String psd) {
        this.psd = psd;
    }

    private String Gender;
    private String[] likes;

    /**
     * @return the likes
     */
    public String[] getLikes() {
        return likes;
    }

    /**
     * @param likes
     *            the likes to set
     */
    public void setLikes(String[] likes) {
        this.likes = likes;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return Gender;
    }

    /**
     * @param gender
     *            the gender to set
     */
    public void setGender(String gender) {
        Gender = gender;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @Title: User
     * @param name
     */
    public User(String name) {
        super();
        this.name = name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @Title: User
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
}
