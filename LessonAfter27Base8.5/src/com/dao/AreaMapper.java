package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import javabean.Area;

/**
 * @ClassName: AreaMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月18日 上午7:10:29
 * 
 */
public interface AreaMapper {
    @Select("select * from dt_area where area_parent_id = 0")
    @Results(id = "areaResultmap", value = { @Result(column = "area_name", property = "name"),
            @Result(column = "area_code", property = "code"), @Result(column = "area_parent_id", property = "parentId"),
            @Result(column = "init_date", property = "initDate"),
            @Result(column = "init_addr", property = "initAddr") })
    List<Area> queryProvinces();

    @Select("select * from dt_area where area_parent_id = #{parentId}")
    @ResultMap(value = "areaResultmap")
    List<Area> queryCities(int parentId);

   
}
