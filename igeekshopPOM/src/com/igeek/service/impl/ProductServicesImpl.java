package com.igeek.service.impl;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.igeek.dao.IProductMapper;
import com.igeek.domain.Product;
import com.igeek.service.IProductServices;

import tk.mybatis.mapper.entity.Example;

/**
 * @ClassName: ProductServicesImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月26日 下午7:59:16
 * 
 */
public class ProductServicesImpl extends BaseServices implements IProductServices {

    /**
     * @Title: queryList
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param parseInt
     * @param parseInt2
     * @param method
     * @return
     * @see com.igeek.service.IProductServices#queryList(int, int,
     *      java.lang.String)
     */
    @Override
    public Map<String, Object> queryList(int pageNum, int pageSize, String method) {
        String order = method;
        IProductMapper mapper = session.getMapper(IProductMapper.class);

        Example pExample = new Example(Product.class);

        if (order.contains("Hot")) {
            order = "查询热销商品";
            pExample.createCriteria().andEqualTo("isHot", 1);
        } else if (order.contains("New")) {
            order = "查询最新商品";
            pExample.orderBy("pdate").desc();
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Product> list = mapper.selectByExample(pExample);
        int flag = list == null ? 0 : 1;
        judge(flag, list, order);
        return map;
    }

    /**
     * @Title: queryCategoryInfo
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param parseInt
     * @param parseInt2
     * @see com.igeek.service.IProductServices#queryCategoryInfo(int, int)
     */
    @Override
    public Page<Product> queryCategoryInfo(String cid, int pageNum) {

        IProductMapper mapper = session.getMapper(IProductMapper.class);
        Example pExample = new Example(Product.class);

        pExample.createCriteria().andEqualTo("cid", cid);
        Page<Product> page = PageHelper.startPage(pageNum, 12).doSelectPage(() -> mapper.selectByExample(pExample));
        ;

        return page;
    }

    /**
     * @Title: queryProductsInfo
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param pid
     * @see com.igeek.service.IProductServices#queryProductsInfo(java.lang.String)
     */
    @Override
    public Map<String, Object> queryProductInfo(String pid) {
        String order = "查询商品信息";
        IProductMapper mapper = session.getMapper(IProductMapper.class);
        // mapper.selectByPrimaryKey的问题 必须注解声明主键
        // Product arg0 = new Product();
        // arg0.setPid(pid);
        // Product product = mapper.selectOne(arg0 );
        Product product = mapper.selectByPrimaryKey(pid);
        int flag = product == null ? 0 : 1;
        judge(flag, product, order);
        return map;
    }

}
