package com.igeek.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.igeek.domain.Subject;

import tk.mybatis.mapper.common.Mapper;

/**
 * @ClassName: SubjectMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月7日 下午6:35:09
 * 
 */
public interface SubjectMapper extends Mapper<Subject> {

    List<Integer> selectSubnoByTypeAndDiff(@Param("type") String type, @Param("diff") String diff);

    /**  
    * @Title: selectByPrimaryKeys  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param subnos    
    */
    List<Subject> selectByPrimaryKeys(@Param("subnos")int[] subnos);
    
    Integer deleteInlist(@Param("subnos") String[] subnos);
}
