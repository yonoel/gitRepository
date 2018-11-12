package com.igeek.mvc.service.impl;

import org.springframework.stereotype.Service;

import com.igeek.mvc.dao.IOrdersMapper;
import com.igeek.mvc.domain.Orders;
import com.igeek.mvc.service.IOrdersServices;

/**
 * @ClassName: ICategoryServices
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月26日 下午1:20:42
 * 
 */
@Service
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
