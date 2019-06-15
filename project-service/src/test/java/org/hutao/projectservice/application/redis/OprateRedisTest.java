package org.hutao.projectservice.application.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OprateRedisTest {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void append(){
        String key = "taoge";
        String value = "1111111";
        System.out.println("操作成功："+stringRedisTemplate.opsForValue().append(key, value)); ;
    }

    @Test
    public void add(){

        stringRedisTemplate.opsForValue().set("stringValue","bbb");
        System.out.println("操作成功："); ;
    }

    @Test
    public void addWithTime(){
        String key = "taoge";
        String value = "qq";
        stringRedisTemplate.opsForValue().set(key,value, 15,TimeUnit.SECONDS);
        System.out.println("操作成功："); ;
    }
    @Test
    public void get(){
        String key = "taoge";
        String value = "qq";
        String s = stringRedisTemplate.opsForValue().get(key);
        System.out.println("操作成功：取出的值为==="+s); ;
    }

    @Test
    public void setList(){
        String key = "1111";
        String value = "qq";
        Integer value2 = 1;
        Boolean value3 = true;
        List list = Arrays.asList("hh",1,true);
        redisTemplate.setStringSerializer(RedisSerializer.json());

        Long s = redisTemplate.opsForList().rightPushAll(key,list);
        System.out.println("操作成功：返回的值为==="+s); ;
    }
}
