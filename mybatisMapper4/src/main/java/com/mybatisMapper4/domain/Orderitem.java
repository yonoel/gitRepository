package com.mybatisMapper4.domain;

import javax.persistence.*;

@Table(name = "`orderitem`")
public class Orderitem {
    @Id
    @Column(name = "`itemid`")
    @GeneratedValue(generator = "JDBC")
    private String itemid;

    @Column(name = "`count`")
    private Integer count;

    @Column(name = "`subtotal`")
    private Double subtotal;

    @Column(name = "`pid`")
    private String pid;
    @Transient
    private Product product;
    @Column(name = "`oid`")
    private String oid;
    @Transient
    private Orders orders;
    /**
     * @return itemid
     */
    public String getItemid() {
        return itemid;
    }

    /**
     * @param itemid
     */
    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    /**
     * @return count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * @return subtotal
     */
    public Double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal
     */
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * @return oid
     */
    public String getOid() {
        return oid;
    }

    /**
     * @param oid
     */
    public void setOid(String oid) {
        this.oid = oid;
    }
}