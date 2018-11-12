package atmsystem.spring.services;

import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import atmsystem.spring.dao.AccountMapper;
import atmsystem.spring.domain.Account;
import atmsystem.spring.domain.ConditionAccount;

/**
 * @ClassName: AccountServices
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月11日 下午7:36:47
 * 
 */
// @Service("AccountServices")
public class AccountServices {
    private Map<String, Object> map;
    private SqlSession session;

    /**
     * @param session
     *            the session to set
     */
    public void setSession() {
        String name = "MyBatisCfg.xml";
        InputStream input = AccountServices.class.getClassLoader().getResourceAsStream(name);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
        this.session = factory.openSession();
    }

    /**
     * @return the map
     */
    public Map<String, Object> getMap() {
        return map;
    }

    /**
     * @Title: AccountServices
     */
    public AccountServices() {

        super();

    }

    /**
     * @Title: queryByName
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param name
     * @return
     * @see atmsystem.spring.dao.AccountMapper#queryOne(java.lang.String)
     */
    public Map<String, Object> queryOne(ConditionAccount conAccount) {
        AccountMapper mapper = session.getMapper(AccountMapper.class);
        Account account = mapper.queryOne(conAccount);
        if (account == null) {

            map.put("message", "账户不存在");
        } else if (account.getPassword().intValue() != conAccount.getPassword().intValue()) {
            map.put("message", "密码错误");
        }

        else {
            map.put("message", "查询成功");
            map.put("account", account);
        }
        session.close();
        return map;
    }

    /**
     * @Title: drawCash
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param account
     * @return
     * @see atmsystem.spring.dao.AccountMapper#drawCash(atmsystem.spring.domain.ConditionAccount)
     */
    public Map<String, Object> drawCash(ConditionAccount conditionAccount) {
        AccountMapper mapper = session.getMapper(AccountMapper.class);
        // 余额不足 --->单独写一个
        Account orgin = mapper.queryOne(conditionAccount);
        conditionAccount.setCash(orgin.getCash());

        if (orgin.getCash() < conditionAccount.getDraw()) {
            map.put("message", "余额不足");
            return map;
        }

        int i = mapper.drawCash(conditionAccount);
        if (i == 1) {
            map.put("message", "取款成功");
            orgin.setCash(orgin.getCash() - conditionAccount.getDraw());
            map.put("account", orgin);
        } else {
            map.put("message", "取款失败");
        }

        session.commit();
        session.close();
        return map;
    }

    /**
     * @Title: saveCash
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param account
     * @return
     * @see atmsystem.spring.dao.AccountMapper#saveCash(atmsystem.spring.domain.ConditionAccount)
     */
    public Map<String, Object> saveCash(ConditionAccount conditionAccount) {
        AccountMapper mapper = session.getMapper(AccountMapper.class);
        Account orgin = mapper.queryOne(conditionAccount);
        int i = mapper.saveCash(conditionAccount);
        if (i == 1) {
            map.put("message", "存款成功");
            orgin.setCash(orgin.getCash() + conditionAccount.getSave());
            map.put("account", orgin);
        } else {
            map.put("message", "存款失败");
        }
        session.commit();
        session.close();
        return map;
    }

    /**
     * @Title: transferAccount
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param accounta
     * @param accountb
     * @return
     * @see atmsystem.spring.dao.AccountMapper#transferAccount(atmsystem.spring.domain.ConditionAccount,
     *      atmsystem.spring.domain.ConditionAccount)
     */
    public Map<String, Object> transferAccount(ConditionAccount dest, ConditionAccount orgin) {
        AccountMapper mapper = session.getMapper(AccountMapper.class);
        // 查询是否转给自己
        if (dest.getName().equals(orgin.getName())) {
            map.put("message", "转账用户为自己，转账失败");
            return map;
        }
        // 首先查询目标账户存在与否
        if (mapper.queryOne(dest) == null) {
            map.put("message", "转账用户不存在，转账失败");
            return map;
        }

        // 查询余额是否足够 目标存的钱大于本金,账户余额不足

        if (dest.getSave() > mapper.queryOne(orgin).getCash()) {
            map.put("message", "账户余额不足，转账失败");
            return map;
        }

        int i = mapper.drawCash(orgin);

        int j = mapper.saveCash(dest);
        if (i + j == 2) {

            session.commit();
            map.put("message", "转账成功");
            map.put("account", mapper.queryOne(orgin));
        } else {
            map.put("message", "转账失败");
            session.rollback();
        }
        session.close();

        return map;
    }

}
