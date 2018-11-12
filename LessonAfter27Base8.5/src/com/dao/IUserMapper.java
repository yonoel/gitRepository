package com.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import javabean.User;

/**
 * @ClassName: IUserMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月18日 下午1:25:00
 * 
 */
public interface IUserMapper {
    @Select("select u_name,u_password from user where u_name = #{name}")
    @Results({ @Result(column = "u_name", property = "name"), @Result(column = "u_password", property = "password") })
    User queryByName(User user);
}
