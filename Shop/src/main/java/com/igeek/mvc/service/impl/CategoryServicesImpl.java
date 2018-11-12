package com.igeek.mvc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.igeek.mvc.dao.ICategoryMapper;
import com.igeek.mvc.domain.Category;
import com.igeek.mvc.service.ICategoryServices;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @ClassName: CategoryServices
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月26日 下午1:22:11
 * 
 */
@Service
public class CategoryServicesImpl extends BaseServices implements ICategoryServices {
//    @Autowired
//    private JedisPool jedisPool;

    /**
     * @Title: queryCategory
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return
     * @see com.igeek.service.ICategoryServices#queryCategory()
     */
    @Override
    public Map<String, Object> queryCategory() {
        String order = "查询商品分类";
        int flag;
        ICategoryMapper mapper = session.getMapper(ICategoryMapper.class);
        List<Category> list = mapper.selectAll();
        flag = list == null ? 0 : 1;
        judge(flag, list, order);

        return map;
    }

    /**
     * @Title: queryCategoryByJedis
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return
     * @see com.igeek.mvc.service.ICategoryServices#queryCategoryByJedis()
     */
    
     @Override 
     public Map<String, Object> queryCategoryByJedis() { 
         // TODO Auto-generated
         return null; }
 

    /**
     * @Title: queryCategoryByJedis
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return
     * @see com.igeek.service.ICategoryServices#queryCategoryByJedis()
     */
   
   /* @Override
    public Map<String, Object> queryCategoryByJedis() {
        String order = "查询商品分类";
        int flag = 1;
        List<Category> list = null;
        // 首先访问jedis 查询数据
        Jedis jedis = jedisPool.getResource();
        String category = jedis.get("category");

        if (category == null && "".equals(category)) {
            // 如果jedis没有，调用mysql
            ICategoryMapper mapper = session.getMapper(ICategoryMapper.class);
            list = mapper.selectAll();
            if (list == null) {
                flag = 0;
            }
            judge(flag, list, order);
            // 把数据写入jedis
            category = JSON.toJSONString(map);

            //
            jedis.set("category", category);

        }
        return map;

    }*/

}
