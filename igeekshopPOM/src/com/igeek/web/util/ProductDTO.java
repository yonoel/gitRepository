package com.igeek.web.util;

import com.igeek.domain.Product;

/**
 * @ClassName: ProductDTO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月30日 上午7:31:32
 * 
 */
public class ProductDTO extends Product {
    private Integer quantity;
    private Double subtotal;

    /**
     * @return the subtotal
     */
    public Double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal
     *            the subtotal to set
     */
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     *            the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        if (this.getShopPrice() != null) {
            this.setSubtotal(this.getShopPrice() * quantity);
        }
    }

    /**
     * @Title: hashCode
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
        return result;
    }

    /**
     * @Title: equals
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param obj
     * @return
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductDTO other = (ProductDTO) obj;
        if (this.getPid() == null) {
            if (other.getPid() != null)
                return false;
        } else if (!getPid().equals(other.getPid()))
            return false;
        return true;
    }
}
