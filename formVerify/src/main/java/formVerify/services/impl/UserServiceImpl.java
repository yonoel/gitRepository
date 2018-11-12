package formVerify.services.impl;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import formVerify.dao.impl.UserMapper;
import formVerify.domain.User;
import formVerify.services.IUserServices;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月3日 上午9:30:25
 * 
 */
public class UserServiceImpl implements IUserServices {

    // 理论上应该调用dao层 services
    private SqlSession session;

    /**
     * @Title: UserServiceImpl
     * @param mapper
     */
    public UserServiceImpl() {
        String name = "MyBatisCfg.xml";
        InputStream input = UserServiceImpl.class.getClassLoader().getResourceAsStream(name);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
        this.session = factory.openSession();
    }

    /**
     * @Title: registerUser
     * @Description: regist
     * @param user
     * @throws UserExistException
     * @see formVerify.services.IUserServices#registerUser(formVerify.domain.User)
     */
    @Override
    public int registerUser(User user) throws UserExistException {
        UserMapper mapper = session.getMapper(UserMapper.class);

        if (mapper.queryUserByName(user) != null) {
            throw new UserExistException("注册的用户名已存在");
        }
        int i = mapper.insertUser(user);
        session.commit();
        session.close();
        return i;

    }

    /**
     * @Title: loginUser
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param name
     * @param password
     * @return
     * @see formVerify.services.IUserServices#loginUser(java.lang.String,
     *      java.lang.String)
     */
    @Override
    public User loginUser(String name, String password) {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUserName(name);
        user.setUserPwd(Integer.parseInt(password));
        user = mapper.queryUser(user);
        session.close();
        return user;
    }

    /**
     * @Title: queryUser
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param name
     * @return
     * @see formVerify.services.IUserServices#queryUser(java.lang.String)
     */
    @Override
    public User queryUser(String name) {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUserName(name);
        user = mapper.queryUserByName(user);
        return user;
    }

    /**
     * @Title: delete
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param user
     * @see formVerify.services.IUserServices#delete(formVerify.domain.User)
     */
    @Override
    public int delete(User user) {
        UserMapper mapper = session.getMapper(UserMapper.class);
        return mapper.deleteUser(user);

    }

    /**
     * @Title: update
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param user
     * @see formVerify.services.IUserServices#update(formVerify.domain.User)
     */
    @Override
    public int update(User user) {
        UserMapper mapper = session.getMapper(UserMapper.class);
        int i = mapper.updateUser(user);
        session.commit();
        session.close();
        return i;
    }

}
