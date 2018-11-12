package com.example.SpringBootStudy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootStudy.domain.User;

/**  
* @ClassName: UserRepository  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年8月7日 上午8:48:52    
*    
*/

public interface UserRepository extends JpaRepository<User,String>{
    User findByUserName(String userName);
}
