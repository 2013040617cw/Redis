package com.cuiwei;

import com.cuiwei.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class SpringdataDemoApplicationTests {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Test
    void testString() {
         //写入一条数据
        redisTemplate.opsForValue().set("name","崔巍");
        //获取数据
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);

    }
    @Test
    void testSaveUser(){
        //写入数据
        redisTemplate.opsForValue().set("user:1",new User("郭士琪",21));
        //获取数据
       User user =(User) redisTemplate.opsForValue().get("user:1");

        System.out.println(user);



    }
}
