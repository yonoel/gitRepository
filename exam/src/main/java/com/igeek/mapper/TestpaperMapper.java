package com.igeek.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.igeek.domain.Testpaper;

import tk.mybatis.mapper.common.Mapper;

/**
 * @ClassName: TestpaperMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月8日 下午8:51:59
 * 
 */
public interface TestpaperMapper extends Mapper<Testpaper> {
    @Select("SELECT CASE WHEN p.score > 0 THEN 1 ELSE 0 END result FROM testpaper p WHERE  `testno` = #{testno}")
    Boolean exsiteScore(@Param("testno") Integer testno);

    Integer deleteInList(@Param("testnos") List<Integer> testnos);
    
    Boolean setScore(@Param("testno")Integer testno);
}
