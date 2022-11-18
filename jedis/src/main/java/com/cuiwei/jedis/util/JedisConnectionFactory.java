package com.cuiwei.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionFactory {

    private static final JedisPool jedisPoll;

    static {
        //配置连接池
        JedisPoolConfig PoolConfig = new JedisPoolConfig();
        PoolConfig.setMaxTotal(8);
        PoolConfig.setMaxIdle(8);
        PoolConfig.setMinIdle(0);
        PoolConfig.setMaxWaitMillis(1000);
        //创建连接池对象
        jedisPoll = new JedisPool(PoolConfig,
                "192.168.37.128",6379);

    }

    public static Jedis getJedis(){
        return jedisPoll.getResource();
    }
}
