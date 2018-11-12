package formVerify.services;

import formVerify.domain.User;
import formVerify.services.impl.UserExistException;

/**
 * @ClassName: IUserServices
 * @Description: 对web层提供业务服务
 * @date 2018年7月3日 上午9:28:52
 * 
 */
public interface IUserServices {
    /**
     * 提供注册服务
     * 
     * @param user
     * @throws UserExistException
     */
    int registerUser(User user) throws UserExistException;

    /**
     * 提供登录服务
     * 
     * @param userName
     * @param userPwd
     * @return
     */
    User loginUser(String name, String password);

    User queryUser(String name);

    /**
     * @Title: delete
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param user
     */
    int delete(User user);

    /**
     * @Title: update
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param user
     */
    int update(User user);
}
