package com.igeek.web.util;

import java.util.ArrayList;
import java.util.List;

import com.igeek.domain.Orders;

/**
 * @ClassName: OrdersDTO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月30日 上午7:30:30
 * 
 */
public class OrdersDTO extends Orders {
    private List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();

    /**
     * @return the productDTOs
     */
    public List<ProductDTO> getProductDTOs() {
        return productDTOs;
    }

    private Double total;

    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total
     *            the total to set
     */
    public void setTotal() {
        Double total = this.productDTOs.stream().filter(p -> p.getSubtotal() != null).map(p -> p.getSubtotal())
                .reduce(0.0, Double::sum);
        this.total = total;
    }

    /**
     * @param productDTOs
     *            the productDTOs to set
     */
    public void setProductDTOs(List<ProductDTO> productDTOs) {
        this.productDTOs = productDTOs;
        setTotal();
    }

}
