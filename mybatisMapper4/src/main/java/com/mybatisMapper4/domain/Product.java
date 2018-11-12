package com.mybatisMapper4.domain;

import java.util.Date;
import javax.persistence.*;

import org.apache.ibatis.annotations.One;

import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "`product`")
public class Product {
    @Id
    @Column(name = "`pid`")
    private String pid;

    @Column(name = "`pname`")
    private String pname;

    @Column(name = "`market_price`")
    private Double marketPrice;

    @Column(name = "`shop_price`")
    private Double shopPrice;

    @Column(name = "`pimage`")
    private String pimage;

    @Column(name = "`pdate`")
    private Date pdate;

    @Column(name = "`is_hot`")
    private Integer isHot;

    @Column(name = "`pdesc`")
    private String pdesc;

    @Column(name = "`pflag`")
    private Integer pflag;
    // 外键声明
    @JoinColumn(name = "`cid`")
    @Column(name = "`cid`")
    private String cid;
    
  
    private Category category;

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category
     *            the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @Title: toString
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Product [pid=" + pid + ", pname=" + pname + ", marketPrice=" + marketPrice + ", shopPrice=" + shopPrice
                + ", pimage=" + pimage + ", pdate=" + pdate + ", isHot=" + isHot + ", pdesc=" + pdesc + ", pflag="
                + pflag + ", cid=" + cid + ", category=" + category + "]";
    }

    /**
     * @param pid
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * @return pname
     */
    public String getPname() {
        return pname;
    }

    /**
     * @param pname
     */
    public void setPname(String pname) {
        this.pname = pname;
    }

    /**
     * @return market_price
     */
    public Double getMarketPrice() {
        return marketPrice;
    }

    /**
     * @param marketPrice
     */
    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * @return shop_price
     */
    public Double getShopPrice() {
        return shopPrice;
    }

    /**
     * @param shopPrice
     */
    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
    }

    /**
     * @return pimage
     */
    public String getPimage() {
        return pimage;
    }

    /**
     * @param pimage
     */
    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    /**
     * @return pdate
     */
    public Date getPdate() {
        return pdate;
    }

    /**
     * @param pdate
     */
    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    /**
     * @return is_hot
     */
    public Integer getIsHot() {
        return isHot;
    }

    /**
     * @param isHot
     */
    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    /**
     * @return pdesc
     */
    public String getPdesc() {
        return pdesc;
    }

    /**
     * @param pdesc
     */
    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    /**
     * @return pflag
     */
    public Integer getPflag() {
        return pflag;
    }

    /**
     * @param pflag
     */
    public void setPflag(Integer pflag) {
        this.pflag = pflag;
    }

    /**
     * @return cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid
     */
    public void setCid(String cid) {
        this.cid = cid;
    }
}