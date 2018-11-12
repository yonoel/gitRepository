package com.igeek.mvc.service;

import java.util.Map;

import com.github.pagehelper.Page;
import com.igeek.mvc.domain.Product;

/**
 * @ClassName: IProductServices
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月26日 下午7:59:28
 * 
 */

public interface IProductServices {

    /**
     * @Title: queryList
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param parseInt
     * @param parseInt2
     * @param method
     * @return
     */
    Map<String, Object> queryList(int parseInt, int parseInt2, String method);

    /**
     * @Title: queryCategoryInfo
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param parseInt
     * @param parseInt2
     */
    Page<Product> queryCategoryInfo(String cid, int pageNum);

    /**  
    * @Title: queryProductsInfo  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param pid    
    */
    Map<String, Object> queryProductInfo(String pid);
}
