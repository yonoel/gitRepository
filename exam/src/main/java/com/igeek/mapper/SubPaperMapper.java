package com.igeek.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.igeek.DTO.SubjectDTO;
import com.igeek.domain.SubPaper;

import tk.mybatis.mapper.common.Mapper;

/**
 * @ClassName: SubPaper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月10日 上午7:22:23
 * 
 */
public interface SubPaperMapper extends Mapper<SubPaper>{
    Integer deleteInList(@Param("testnos") List<Integer> testnos);

    Integer selectCountInList(@Param("testnos") List<Integer> testnos);

    List<SubjectDTO> selectSubjectDTOByTestno(@Param("testno") Integer testno);
}
