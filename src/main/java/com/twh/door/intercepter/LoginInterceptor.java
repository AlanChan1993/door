package com.twh.door.intercepter;

import com.alibaba.fastjson.JSONObject;
import com.twh.door.entity.POJO.DoorUser;
import com.twh.door.services.DoorUserService;
import com.twh.door.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    DoorUserService userService;
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        //获取token
        String token=request.getHeader("token");
        log.info("从头部获取的token==:{} ",token);
        //redis----------------start----------------
/*        try {
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            String redisToken = operations.get(token);
            if (redisToken == null) {
                throw new RuntimeException();
            }
            //Map<String, Object> claims = JwtUtil.parseToken(token);
            //ThreadLocalUtil.set(claims);
            //return true;
        } catch (Exception e) {
            response.setStatus(401);
            //return false;
        }*/
        //redis----------------end----------------

        if (StringUtils.isNotEmpty(token)){
            //验证token
            boolean result= TokenUtils.verify(token);
            if (result){

                String code=TokenUtils.getUserCode(token);
                log.info("用户标识code=:{}", code);
                DoorUser userBean=userService.getUserByUserName(code);
                if (null==userBean){
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"请先登录姐妹");
                }
            }
            return true;
        }
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader ("content-type","text/html;charset=UTF-8");
            response.getWriter().append(JSONObject.toJSONString("请先登录,兄弟"));
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}

