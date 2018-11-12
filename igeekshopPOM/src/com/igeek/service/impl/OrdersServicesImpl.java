package com.igeek.service.impl;

import com.igeek.dao.IOrdersMapper;
import com.igeek.domain.Orders;
import com.igeek.service.IOrdersServices;
import com.igeek.web.util.WebUtils;

/**
 * @ClassName: ICategoryServices
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月26日 下午1:20:42
 * 
 */
public class OrdersServicesImpl extends BaseServices implements IOrdersServices {

    /**
     * @Title: creatNewOrder
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return
     * @see com.igeek.service.IOrdersServices#creatNewOrder()
     */
    @Override
    public int creatNewOrder(Orders orders) {
        // String order = "创建新的订单";

        int flag = session.getMapper(IOrdersMapper.class).insert(orders);
        // judge(flag, orders, order);
        session.commit();
        return flag;
    }

}
