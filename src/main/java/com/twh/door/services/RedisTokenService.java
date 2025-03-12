package com.twh.door.services;

public interface RedisTokenService {
    void saveTokenToRedis(String userToken,String token);
}
