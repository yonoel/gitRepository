package com.igeek.mvc.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.igeek.mvc.dao.IUserMapper;
import com.igeek.mvc.domain.User;
import com.igeek.mvc.service.IUserServices;

/**
 * @ClassName: UserServicesImpl
 * @Description:
 * @date 2018年7月25日 下午6:16:35
 * 
 */
@Service
public class UserServicesImpl extends BaseServices implements IUserServices {

    /**
     * @Title: queryUser
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param userDTO
     * @return
     * @see com.igeek.service.IUserServices#queryUser(com.igeek.web.util.UserDTO)
     */
    @Override
    public Map<String, Object> queryUser(User user) {
        String order = "查询用户";
        IUserMapper mapper = session.getMapper(IUserMapper.class);
        // 这个方法是全字段匹配。。。

        User uname = new User();
        uname.setUsername(user.getUsername());
        //
        User selectOne = mapper.selectOne(uname);
        int flag = selectOne == null ? -3 : 1;
        // -3失败 1成功
        if (flag != -3) {
            if (user.getPassword() != null && user.getPassword().length() > 0) {
                if (!selectOne.getPassword().equals(user.getPassword())) {
                    flag = -1;
                } else if (selectOne.getState() != 1) {
                    flag = -4;
                }
            }
        }

        judge(flag, selectOne, order);
        session.close();
        return map;
    }

    /**
     * @Title: insertUser
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param userDTO
     * @return
     * @see com.igeek.service.IUserServices#insertUser(com.igeek.web.util.UserDTO)
     */
    @Override
    public Map<String, Object> insertUser(User user) {
        String order = "注册用户";
        IUserMapper mapper = session.getMapper(IUserMapper.class);
        User user2 = mapper.selectOne(user);
        int flag = 0;
        if (user2 != null) {
            // flag -2 user重复
            flag = -2;
        } else {
            user.setState(0);
            flag = mapper.insert(user);
        }
        judge(flag, user, order);
        session.commit();
        session.close();
        return map;
    }

    /**
     * @Title: activeUser
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param code
     * @return
     * @see com.igeek.service.IUserServices#activeUser(java.lang.String)
     */
    @Override
    public Map<String, Object> activeUser(String code) {
        String order = "激活用户";
        IUserMapper mapper = session.getMapper(IUserMapper.class);
        User user = mapper.selectByPrimaryKey(code);
        int flag = 0;
        if (user == null) {
            flag = -3;
        } else {
            user.setState(1);
            flag = mapper.updateByPrimaryKey(user);
        }
        judge(flag, user, order);
        return map;
    }

}
