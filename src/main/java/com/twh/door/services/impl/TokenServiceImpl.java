package com.twh.door.services.impl;

import com.twh.door.services.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class TokenServiceImpl implements TokenService {
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    @Override
    public String getTokenByuName(String uName) {
        try (Jedis jedis = new Jedis(host, Integer.parseInt(port))) {
            return jedis.get(uName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
