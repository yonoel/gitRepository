package com.mybatisMapper4.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mybatisMapper4.domain.Area;

import tk.mybatis.mapper.common.Mapper;

/**  
* @ClassName: AreaMapper  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年8月8日 下午4:02:52    
*    
*/
public interface AreaMapper extends Mapper<Area>{
    @Select("select * from area where ccode = #{ccode}")
    @Results(id="AreaResultMap",value= {
            @Result(column="id", property="id")
            ,@Result(column="areaname", property="areaname")
    })
    //List<Area> getAreas(@Param("ccode")String ccode);
    List<Area> getAreas(String ccode);
}
