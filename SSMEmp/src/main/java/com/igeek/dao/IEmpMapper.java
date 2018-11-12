package com.igeek.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;

import com.igeek.domain.Emp;

import tk.mybatis.mapper.common.Mapper;

/**
 * @ClassName: IEmpMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月21日 上午11:00:35
 * 
 */
public interface IEmpMapper extends Mapper<Emp> {
    
    List<Emp> queryEmpLike(@Param("emp") Emp emp);
}
