package formVerify.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import formVerify.domain.User;

/**
 * @ClassName: UserMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月3日 上午8:06:12
 * 
 */
@Mapper
public interface UserMapper {

    @Select("select * from user ")
    List<User> queryAllUser();

    @Select("select * from user where u_name = #{userName}")
    @ResultMap(value = "UserResultMap")
    User queryUserByName(User user);

    @Insert("insert into user value (#{id},#{userName},#{userPwd},#{email},#{birthday}) ")
    int insertUser(User user);

    @Delete("delete from user where u_name = #{userName} ")
    int deleteUser(User user);

    @Update("update User set u_name = #{userName},u_password = #{userPwd},u_email=#{email},u_birthday = #{birthday} where u_id = #{id} ")
    int updateUser(User user);

    /**
     * @Title: queryUser
     * @Description: 根据name和password查询
     * @param user
     * @return
     */
    @Select("select * from user where u_name = #{userName} and u_password = #{userPwd}")
    @Results(id = "UserResultMap", value = { @Result(column = "u_id", property = "id"),
            @Result(column = "u_name", property = "userName"), @Result(column = "u_password", property = "userPwd"),
            @Result(column = "u_email", property = "email"), @Result(column = "u_birthday", property = "birthday") })
    User queryUser(User user);

}
