package com.igeek.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.igeek.domain.Dept;

/**
 * @ClassName: DeptServicesImpTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月23日 下午12:07:11
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:Spring-mybatis.xml")
public class DeptServicesImpTest {
    @Resource
    private IDeptServices services;

    @Test
    public void test() {
        Map<String, Object> map = services.queryAll();
        assertNotNull(map);

    }

    @Test
    // 这个是事务开启，会自动回滚
    @Transactional
    public void testrollback() {
        Dept dept = new Dept();
        dept.setDeptno(123);
        assertEquals(1, services.insertDept(dept));
        
        System.out.println(44);

    }

}
