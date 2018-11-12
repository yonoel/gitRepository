package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ClassName: RedisConnection
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月25日 上午10:43:01
 * 
 */
public class RedisConnection {
    public static void main(String[] args) {
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();

        config.setMaxIdle(5);
        config.setTestOnBorrow(false);
        // 获取jedispool
        JedisPool pool = new JedisPool(config, "192.168.6.77", 6379);

        Jedis jedis = pool.getResource();

        jedis.set("num1", "123");
       
    }
}
