package com.igeek.service.impl;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.igeek.dao.ICategoryMapper;
import com.igeek.domain.Category;
import com.igeek.service.ICategoryServices;
import com.igeek.web.util.WebUtils;

import redis.clients.jedis.Jedis;

/**
 * @ClassName: CategoryServices
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月26日 下午1:22:11
 * 
 */
public class CategoryServicesImpl extends BaseServices implements ICategoryServices {

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
     * @see com.igeek.service.ICategoryServices#queryCategoryByJedis()
     */
    @SuppressWarnings("null")
    @Override
    public String queryCategoryByJedis() {
        String order = "查询商品分类";
        int flag = 1;
        List<Category> list = null;
        // 首先访问jedis 查询数据
        Jedis jedis = WebUtils.getJedis();
        String category = jedis.get("category");

        if (category == null || "".equals(category)) {
            // 如果jedis没有，调用mysql
            ICategoryMapper mapper = session.getMapper(ICategoryMapper.class);
            list = mapper.selectAll();
            if (list == null) {
                flag = 0;
            }
            judge(flag, list, order);
            // 把数据写入jedis
            Gson gson = new Gson();
            category = gson.toJson(map);
            //
            jedis.set("category", category);

        }
        return category;

    }

}
