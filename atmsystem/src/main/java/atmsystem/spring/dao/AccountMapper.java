package atmsystem.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import atmsystem.spring.domain.Account;
import atmsystem.spring.domain.ConditionAccount;

/**
 * @ClassName: AccountMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月11日 下午6:00:00
 * 
 */
public interface AccountMapper {

    // query 2种
    @Select("select * from account")
    List<Account> queryAll() ;

    @Select("select * from account where name = #{name} ")
    Account queryOne(ConditionAccount account);

    // getmoney
    @Update("update account set cash=cash-#{draw} where name = #{name}")
    int drawCash(ConditionAccount account);

    // savemoney
    @Update("update account set cash=cash+#{save} where name = #{name}")
    int saveCash(ConditionAccount account);

    // transfer
    // 其实就是执行了取和存。。在service层具体写吧
    int transferAccount(ConditionAccount dest, ConditionAccount orgin);
}
