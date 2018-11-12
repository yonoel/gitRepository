package com.igeek.serviceImpl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.igeek.domain.User;
import com.igeek.mapper.UserMapper;
import com.igeek.service.IUserService;

/**
 * @ClassName: UserServicesImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月7日 下午6:49:07
 * 
 */
@Service
public class UserServicesImpl extends BaseServices implements IUserService {
    

    /**
     * @Title: query
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param user
     * @return
     * @see com.igeek.service.IUserService#query(com.igeek.domain.User)
     */
    @Override
    public boolean query(User user) {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        return mapper.selectOne(user) != null ? true : false;
    }

    /**  
    * @Title: getUserByNameAndPassword  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param user
    * @return
    * @see com.igeek.service.IUserService#getUserByNameAndPassword(com.igeek.domain.User)
    */
    @Override
    public User getUserByNameAndPassword(User user) {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userDTO = mapper.selectOne(user);
        return userDTO;
    }

    /**  
    * @Title: pageQuery  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param pagenum
    * @return
    * @see com.igeek.serviceImpl.BaseServices#pageQuery(java.lang.Integer)
    */
    @Override
    public Map<String, Object> pageQuery(Integer pagenum) {
        // TODO Auto-generated method stub
        return null;
    }

}
