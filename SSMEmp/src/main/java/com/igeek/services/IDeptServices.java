package com.igeek.services;

import java.util.Map;

import com.igeek.domain.Dept;

/**  
* @ClassName: IDeptServices  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年7月23日 上午11:59:44    
*    
*/
public interface IDeptServices {
    // 查询所有dept
    Map<String,Object> queryAll();
    // 插入一个Dept
    int insertDept(Dept dept);
    
}
