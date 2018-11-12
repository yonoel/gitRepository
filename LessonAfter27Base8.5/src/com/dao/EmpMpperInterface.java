package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import javabean.Emp;

/**
 * @ClassName: EmpMpperInterface
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月16日 下午4:53:29
 * 
 */
public interface EmpMpperInterface {
    // crud
    @Insert("insert into emp values (#{id},#{name},#{job}"

            + ",#{hirDate},#{sal},#{comm},#{deptno} ")
    int insertIntoEmp(Emp emp);

    @Results(id = "EmpResultMap", value = { @Result(column = "empno", property = "id"),
            @Result(column = "ename", property = "name")

    })
    @Select("select * from emp where empno = #{empNo}")
    Emp queryById(int empNo);

    @ResultMap(value = "EmpResultMap")
    @Select("select * from emp ")
    List<Emp> queryAll();

    @Delete("delete from emp where empno = #{empNo}")
    int deleteEmp(int empNo);

}
