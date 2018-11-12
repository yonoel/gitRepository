package com.mybatisMapper4.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`orders`")
public class Orders {
    @Id
    @Column(name = "`oid`")
    @GeneratedValue(generator = "JDBC")
    private String oid;

    @Column(name = "`ordertime`")
    private Date ordertime;

    @Column(name = "`total`")
    private Double total;

    @Column(name = "`state`")
    private Integer state;

    @Column(name = "`address`")
    private String address;

    @Column(name = "`name`")
    private String name;

    @Column(name = "`telephone`")
    private String telephone;

    @Column(name = "`uid`")
    private String uid;

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

    /**
     * @return ordertime
     */
    public Date getOrdertime() {
        return ordertime;
    }

    /**
     * @param ordertime
     */
    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    /**
     * @return total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * @return state
     */
    public Integer getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }
}