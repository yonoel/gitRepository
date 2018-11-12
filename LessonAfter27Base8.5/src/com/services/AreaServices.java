package com.services;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dao.AreaMapper;

import javabean.Area;

/**
 * @ClassName: AreaServices
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月18日 上午7:32:54
 * 
 */
public class AreaServices {
    private AreaMapper mapper;

    public List<Area> queryProvinces() {
        return mapper.queryProvinces();
    }

    public List<Area> queryCities(int parentId) {
        return mapper.queryCities(parentId);
    }

    /**
     * @Title: AreaServices
     */
    public AreaServices() {
        super();
        String name = "MyBatisCfg.xml";
        InputStream inputStream = AreaServices.class.getClassLoader().getResourceAsStream(name);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        this.mapper = factory.openSession().getMapper(AreaMapper.class);
    }

    /**
     * @Title: queryZones
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param parentId
     * @return
     */
    public List<Area> queryZones(int parentId) {

        return mapper.queryCities(parentId);
    }

}
