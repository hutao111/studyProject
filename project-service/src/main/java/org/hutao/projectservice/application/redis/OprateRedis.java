package org.hutao.projectservice.application.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class OprateRedis {
    @Autowired
    RedisTemplate redisTemplate;

    public Integer add(String key,String value){
        return redisTemplate.opsForValue().append(key, value);
    }
}
