package com.igeek.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igeek.dao.IDeptMapper;
import com.igeek.domain.Dept;

/**
 * @ClassName: DeptServicesImp
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月23日 上午11:57:50
 * 
 */
@Service
public class DeptServicesImp implements IDeptServices {
    // services 的map ，可以丢给controller做model
    private Map<String, Object> map = new HashMap<>();
    // dao的mapper
    @Resource
    private IDeptMapper mapper;

    /**
     * @Title: DeptServicesImp
     */
    public DeptServicesImp() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void judge(int flag, Object obj, String order) {
        if (flag == 1) {
            map.put("flag", true);
            map.put(order, "成功");
            map.put("dept", obj);
        } else {
            map.put("flag", false);
            map.put(order, "失败");
        }
    }

    /**
     * @Title: queryAll
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return
     * @see com.igeek.services.IDeptServices#queryAll()
     */
    @Override
    public Map<String, Object> queryAll() {
        String order = "查询";
        int flag;
        List<Dept> list = mapper.selectAll();
        flag = (list == null) ? 0 : 1;
        judge(flag, list, order);
        return map;
    }

    /**  
    * @Title: insertDept  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param dept
    * @return
    * @see com.igeek.services.IDeptServices#insertDept(com.igeek.domain.Dept)
    */
    @Override
    public int insertDept(Dept dept) {
        
        return mapper.insert(dept);
    }

}
