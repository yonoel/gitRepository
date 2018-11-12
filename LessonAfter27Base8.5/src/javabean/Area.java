package javabean;

import java.util.Date;

/**
 * @ClassName: Area
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月18日 上午7:07:20
 * 
 */
public class Area {
    private int id;
    private String name;
    private String code;
    private int parentId;
    private Date initDate;
    private String initAddr;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

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
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the parentId
     */
    public int getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     *            the parentId to set
     */
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    /**
     * @return the initDate
     */
    public Date getInitDate() {
        return initDate;
    }

    /**
     * @param initDate
     *            the initDate to set
     */
    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    /**
     * @return the initAddr
     */
    public String getInitAddr() {
        return initAddr;
    }

    /**
     * @param initAddr
     *            the initAddr to set
     */
    public void setInitAddr(String initAddr) {
        this.initAddr = initAddr;
    }

    /**
     * @Title: Area
     */
    public Area() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @Title: Area
     * @param id
     * @param name
     * @param code
     * @param parentId
     * @param initDate
     * @param initAddr
     */
    public Area(int id, String name, String code, int parentId, Date initDate, String initAddr) {
        super();
        this.id = id;
        this.name = name;
        this.code = code;
        this.parentId = parentId;
        this.initDate = initDate;
        this.initAddr = initAddr;
    }

    /**
     * @Title: toString
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Area [id=" + id + ", name=" + name + ", code=" + code + ", parentId=" + parentId + ", initDate="
                + initDate + ", initAddr=" + initAddr + "]";
    }

}
