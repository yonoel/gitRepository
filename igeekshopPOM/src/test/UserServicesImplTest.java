package test;

import java.io.InputStream;

import org.apache.commons.dbutils.DbUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.igeek.dao.IProductMapper;
import com.igeek.dao.IUserMapper;
import com.igeek.dao.util.DaoUtils;
import com.igeek.domain.Product;
import com.igeek.domain.User;
import com.igeek.service.impl.UserServicesImpl;
import com.igeek.web.util.WebUtils;

import redis.clients.jedis.Jedis;
import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

/**
 * @ClassName: UserServicesImplTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月25日 下午6:50:12
 * 
 */
public class UserServicesImplTest {
    public static void main(String[] args) {
        Jedis jedis = WebUtils.getJedis();
        jedis.set("haha", "hehe");
        System.out.println(jedis.get("haha"));
    }

    @Test
    public void testPrimaryKey() {
        IProductMapper mapper = DaoUtils.getSqlSession().getMapper(IProductMapper.class);
        Product product = mapper.selectByPrimaryKey(1);
        System.out.println(product.getPid());
    }

    @Test
    public void testJedis() {
        Jedis jedis = WebUtils.getJedis();
        jedis.set("haha", "hehe");
    }

    /**
     * Test method for
     * {@link com.igeek.service.impl.UserServicesImpl#queryUser(com.igeek.domain.User)}.
     */
    @Test
    public void testQueryUser() {
        // UserServicesImpl servicesImpl = new UserServicesImpl();
        // User user = new User();
        // user.setName("aaa");
        // IUserMapper mapper =
        // DaoUtils.getSqlSession().getMapper(IUserMapper.class);
        // servicesImpl.queryUser(user);
    }

    /**
     * Test method for
     * {@link com.igeek.service.impl.UserServicesImpl#insertUser(com.igeek.domain.User)}.
     */
    @Test
    public void testInsertUser() {
        String name = "MyBatisConfig.xml";
        InputStream inputStream = DaoUtils.class.getClassLoader().getResourceAsStream(name);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        MapperHelper mapperHelper = new MapperHelper();
        // 设置配置
        mapperHelper.setConfig(new Config());
        // 配置 mapperHelper 后，执行下面的操作
        mapperHelper.processConfiguration(session.getConfiguration());
        IUserMapper mapper = session.getMapper(IUserMapper.class);

    }

}
