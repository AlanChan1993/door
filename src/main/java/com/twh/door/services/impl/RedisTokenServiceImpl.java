package com.twh.door.services.impl;

import com.twh.door.services.RedisTokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class RedisTokenServiceImpl implements RedisTokenService {
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;
    public void saveTokenToRedis(String userName,String token) {
        try (Jedis jedis = new Jedis(host, Integer.parseInt(port))) {
            jedis.set(userName, token);
            // 设置Token的过期时间，例如1小时
            jedis.expire(userName, 60*15);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
