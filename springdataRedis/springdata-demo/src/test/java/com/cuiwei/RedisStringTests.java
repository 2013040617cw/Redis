package com.cuiwei;

import com.cuiwei.redis.pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class RedisStringTests {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    //ObjectMapper时springMVC默认使用的JSON工具
    private static final ObjectMapper mapper = new ObjectMapper();
    @Test
    void testString() {
         //写入一条数据
        stringRedisTemplate.opsForValue().set("name1","李慧糠");
        //获取数据
        Object name = stringRedisTemplate.opsForValue().get("name1");
        System.out.println(name);

    }
    @Test
    void testSaveUser() throws Exception{
         //创建对象
        User user = new User("赵文超",22);

        //手动序列化
        String json= mapper.writeValueAsString(user);
        //写入数据
        stringRedisTemplate.opsForValue().set("user:2",json);

        //获取数据
        String jsonUser = stringRedisTemplate.opsForValue().get("user:2");

        //手动反序列化,就是把拿到的JSON格式转化为User类型
        User user1 = mapper.readValue(jsonUser, User.class);
        System.out.println(user1);

    }
}
