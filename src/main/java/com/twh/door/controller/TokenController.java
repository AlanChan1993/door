package com.twh.door.controller;

import com.twh.door.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RequestMapping("/TokenController")
@RestController
public class TokenController {
    @Autowired
    private TokenService service;

    @GetMapping("/getToken")
    public String getToken(String uName) {
        return  service.getTokenByuName(uName);
       /* try (Jedis jedis = new Jedis(host, Integer.parseInt(port))) {
            return jedis.get(uName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }*/
    }
}
