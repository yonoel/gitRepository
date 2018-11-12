package com.igeek.services;

import java.util.Map;

import com.igeek.domain.Emp;

/**
 * @ClassName: IEmpServices
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月19日 下午6:49:15
 * 
 */
public interface IEmpServices {
    Map<String, Object> queryEmp(Emp emp);

    Map<String, Object> queryAll(String pageNum);

    Map<String, Object> insertEmp(Emp emp);

    Map<String, Object> deleteEmp(Emp emp);

    Map<String, Object> updateEmp(Emp emp);
}
