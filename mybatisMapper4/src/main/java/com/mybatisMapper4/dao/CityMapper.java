package com.mybatisMapper4.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mybatisMapper4.domain.City;

import tk.mybatis.mapper.common.Mapper;

/**
 * @ClassName: CityMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月8日 下午4:03:12
 * 
 */
public interface CityMapper extends Mapper<City> {
    // @Select("select c.*,a.id id,a.areaname from city c inner join area a on
    // a.ccode = c.cid")
    @Select("select * from city where pcode = #{pcode}")
    @Results(value = { @Result(column = "cid", property = "code"),
            @Result(column = "citname", property = "name"),
            @Result(property = "district", column = "cid", 
            many = @Many(select = "com.mybatisMapper4.dao.AreaMapper.getAreas")) })
    //List<City> getCity(@Param("pcode") String pcode);
    List<City> getCity(String pcode);
}
