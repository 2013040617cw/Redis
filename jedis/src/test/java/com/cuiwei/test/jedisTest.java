package com.cuiwei.test;

import com.cuiwei.jedis.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class jedisTest {

    private Jedis jedis;

    @BeforeEach
    void setUp() {
        // 1.建立连接
//        jedis = new Jedis("192.168.37.128",6379);
        jedis = JedisConnectionFactory.getJedis();
        //2.选择库
        jedis.select(3);
    }

    @Test
    public void testString(){
        //存入数据
        String result= jedis.set("name", "崔巍");
        System.out.println("result = " + result);
        //获取数据
        jedis.get("name");
    }

    @Test
    public void testHash(){
        //插入Hash数据
        jedis.hset("user:1","name","李慧糠");
        jedis.hset("user:1","age","22");

        //获取数据
        Map<String, String> map = jedis.hgetAll("user:1");
        System.out.println(map);
    }
    //释放连接
    @AfterEach
    void tearDown() {
        if(jedis!=null){
            jedis.close();
        }
    }
}
