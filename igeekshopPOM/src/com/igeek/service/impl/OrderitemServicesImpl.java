package com.igeek.service.impl;

import java.util.Map;

import com.igeek.dao.IOrderitemMapper;
import com.igeek.domain.Orderitem;
import com.igeek.domain.Orders;
import com.igeek.domain.Product;
import com.igeek.service.IOrderitemServices;
import com.igeek.service.IProductServices;

import tk.mybatis.mapper.entity.Example;

/**
 * @ClassName: OrderitemServicesImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月28日 下午1:46:41
 * 
 */
public class OrderitemServicesImpl extends BaseServices implements IOrderitemServices {

    /**
     * @Title: creatNewOrderitem
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param pid
     * @param num
     * @see com.igeek.service.IOrderitemServices#creatNewOrderitem(java.lang.String,
     *      java.lang.String)
     */
    @Override
    public int creatNewOrderitem(Orderitem item) {

        IOrderitemMapper mapper = session.getMapper(IOrderitemMapper.class);

        int flag = mapper.insert(item);
        
        session.commit();
        return flag;
    }

    /**
     * @Title: getSubtotal
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param pid
     * @param num
     * @return
     */
    public Double getSubtotal(String pid, String num) {
        IProductServices services = new ProductServicesImpl();

        Map<String, Object> map = services.queryProductInfo(pid);

        Product product = (Product) map.get("object");

        Double subtotal = product.getShopPrice() * Double.parseDouble(num);
        return subtotal;
    }

    /**
     * @Title: queryProduct
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param pid
     * @return
     * @see com.igeek.service.IOrderitemServices#queryProduct(java.lang.String)
     */
    @Override
    public boolean queryItemExsit(String pid, String oid) {

        IOrderitemMapper mapper = session.getMapper(IOrderitemMapper.class);
        Example itemsExample = new Example(Orderitem.class);
        itemsExample.createCriteria().andEqualTo("oid", oid).andEqualTo("pid", pid);

        return !mapper.selectByExample(itemsExample).isEmpty();
    }

    /**
     * @Title: updataItem
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param pid
     * @param num
     * @param order
     * @see com.igeek.service.IOrderitemServices#updataItem(java.lang.String,
     *      java.lang.String, com.igeek.domain.Orders)
     */
    @Override
    public Orderitem updataItem(String pid, String num, Orders order) {
        // 已经判断存在与否，不需要再次判断了
        IOrderitemMapper mapper = session.getMapper(IOrderitemMapper.class);

        Orderitem orderitem = new Orderitem();
        // 联合外键
        orderitem.setOid(order.getOid());
        orderitem.setPid(pid);
        orderitem = mapper.selectOne(orderitem);

        Integer count = Integer.parseInt(num);
        int flag = 0;

        if (count == 0) {
            // 如果num = 0 就是删除
            flag = mapper.delete(orderitem);
        } else {
            // 要改价格 ---- >先取当前对象
            // subtotal = pid的价格*num
            Double subtotal = getSubtotal(pid, num);
            orderitem.setSubtotal(subtotal);
            orderitem.setCount(count);
            flag = mapper.updateByPrimaryKey(orderitem);
        }
        session.commit();
        return flag == 0 ? null : orderitem;
    }

}
