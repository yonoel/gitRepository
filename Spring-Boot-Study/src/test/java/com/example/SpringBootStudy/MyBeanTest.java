package com.example.SpringBootStudy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.SpringBootStudy.domain.MyBean;

/**  
* @ClassName: MyBeanTest  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年8月7日 下午2:35:03    
*    
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MyBeanTest {
    @Autowired
    private MyBean MyBean;
    @Test
    public void test() {
       System.out.println(MyBean.getName());
    }

}
