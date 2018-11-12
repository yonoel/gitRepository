package com.example.SpringBootStudy;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.SpringBootStudy.dao.UserRepository;
import com.example.SpringBootStudy.dao.UserRepository2;
import com.example.SpringBootStudy.dao.UserRepository3;
import com.example.SpringBootStudy.domain.User;

/**  
* @ClassName: UserRepositoryTest  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年8月7日 上午8:51:21    
*    
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRepository2 userRepository2;
    @Autowired
    private UserRepository3 userRepository3;
    @Test
    public void test() {
      assertNotNull(userRepository.findAll());
      assertNotNull(userRepository.findByUserName("test"));
      assertNotNull(userRepository2.findAll());
      
     

    }

}
