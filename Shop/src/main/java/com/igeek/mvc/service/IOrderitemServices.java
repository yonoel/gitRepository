package com.igeek.mvc.service;

import com.igeek.mvc.domain.Orderitem;
import com.igeek.mvc.domain.Orders;

/**
 * @ClassName: ICategoryServices
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月26日 下午1:20:42
 * 
 */
public interface IOrderitemServices {
    // 生成新的购买项目
    int creatNewOrderitem(Orderitem order);

    /**  
    * @Title: queryProduct  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param pid
     * @param oid 
    * @return    
    */
    // 查询是否存在这个项目
    boolean queryItemExsit(String pid, String oid);

    /**  
    * @Title: updataItem  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param pid
    * @param num
    * @param order    
    */
    Orderitem updataItem(String pid, String num, Orders order);
}
