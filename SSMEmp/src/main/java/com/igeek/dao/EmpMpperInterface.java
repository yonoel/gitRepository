package com.igeek.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.igeek.domain.Emp;

/**
 * @ClassName: EmpMpperInterface
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月16日 下午4:53:29
 * 
 */
public interface EmpMpperInterface {
    // crud
    @Insert("insert into emp values (#{empNo},#{password},#{empName},#{job}"
            + ",#{sex,typeHandler=com.igeek.dao.SexEnumTypeHandler}"
            + ",#{hobbies,typeHandler=com.igeek.dao.HobbiesTypeHandler}" + ",#{mgr}"
            + ",#{hirdate},#{sal},#{comm},#{deptno}) ")
    int insertIntoEmp(Emp emp);

    @Results(id = "EmpResultMap", value = { @Result(column = "ename", property = "empName"),
            @Result(column = "sex", property = "sex", typeHandler = SexEnumTypeHandler.class),
            @Result(column = "hobbies", property = "hobbies", typeHandler = HobbiesTypeHandler.class) })
    @Select("select * from emp where ename = #{empName}")
    Emp queryEmpByname(Emp emp);

    @Select("select * from emp where ename = #{empName} and password =#{password}")
    @ResultMap(value = "EmpResultMap")
    Emp queryEmp(Emp emp);

  
    @Select("select * from emp")
    List<Emp> queryAll();

    @Delete("delete from emp where empno = #{empNo}")
    int deleteEmp(Emp emp);

    @Update("update Emp set ename = #{empName},job = #{jod},sex=#{sex,typeHandler=com.igeek.dao.SexEnumTypeHandler} "
            + ",hobbies = #{hobbies,typeHandler=com.igeek.dao.HobbiesTypeHandler}"
            + ",mgr=#{mgr},hiredate=#{hiredate},sal=#{sal},comm=#{comm},deptno=#{deptno}  where empno = #{empNo} ")
    int updateUser(Emp emp);
}
