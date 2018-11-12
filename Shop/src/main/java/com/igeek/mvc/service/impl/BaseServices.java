package com.igeek.mvc.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: BaseServices
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月25日 下午7:40:59
 * 
 */
@Service
public abstract class BaseServices {
    @Autowired
    protected SqlSession session;
    protected Map<String, Object> map = new HashMap<String, Object>();

    public BaseServices() {
      
    }

    /**
     * @Title: judge
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param flag
     * @param user2
     */
    protected void judge(int flag, Object user2, String order) {
        String message = "";
        map.put("flag", false);
        if (flag == 0) {
            message = String.format("%s失败", order);
        } else if (flag == -1) {
            message = String.format("%s失败,密码错误", order);
        } else if (flag == 1) {
            message = String.format("%s成功", order);
            map.put("flag", true);
        } else if (flag == -2) {
            message = String.format("%s失败,用户存在", order);
        } else if (flag == -3) {
            message = String.format("%s失败,用户不存在", order);
        }else if (flag == -4) {
            message = String.format("%s失败,用户没有激活", order);
        }
        map.put("message", message);
        map.put("object", user2);
    }

    /**
     * @return the session
     */
    public SqlSession getSession() {
        return session;
    }

    /**
     * @param session the session to set
     */
   
    public void setSession(SqlSessionFactory sqlSessionFactory) {
        this.session = sqlSessionFactory.openSession();
    }
}
