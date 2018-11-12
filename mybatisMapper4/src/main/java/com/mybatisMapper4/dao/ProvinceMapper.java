package com.mybatisMapper4.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mybatisMapper4.domain.Province;

import tk.mybatis.mapper.common.Mapper;

/**
 * @ClassName: ProvinceMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月8日 下午4:03:42
 * 
 */
public interface ProvinceMapper extends Mapper<Province> {
    // @Select("SELECT p.*,c.cid cid ,c.citname,a.id id,a.areaName areaName from
    // province p INNER JOIN city c on p.pid = c.pcode INNER JOIN area a on
    // a.ccode = c.cid")
    // @Select("SELECT p.*,c.cid cid ,c.citname from province p INNER JOIN city
    // c on p.pid = c.pcode ")
    @Select("SELECT * from province where pid =#{pid} ")
    @Results(value = { @Result(column = "pid", property = "code"),
            @Result(column = "proname", property = "name"),
            @Result(property = "cities", column = "pid",
            many = @Many(select = "com.mybatisMapper4.dao.CityMapper.getCity")) })
    //Province queryTest(@Param("pid") String pid);
    Province queryTest( String pid);
}
