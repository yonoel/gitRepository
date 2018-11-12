package com.services;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dao.EmpMpperInterface;
import com.dao.IUserMapper;

import javabean.User;

/**
 * @ClassName: UserServices
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月18日 下午1:28:51
 * 
 */
public class UserServices {
    private IUserMapper mapper;

    public UserServices() {
        super();
        String name = "MyBatisCfg.xml";
        InputStream inputStream = AreaServices.class.getClassLoader().getResourceAsStream(name);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        this.mapper = factory.openSession().getMapper(IUserMapper.class);
    }

    public User queryByname(User user) {
        return mapper.queryByName(user);
    }
}
