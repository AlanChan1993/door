package com.twh.door.intercepter;

import com.alibaba.fastjson.JSONObject;
import com.twh.door.controller.TokenController;
import com.twh.door.entity.POJO.DoorUser;
import com.twh.door.services.DoorUserService;
import com.twh.door.services.TokenService;
import com.twh.door.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private DoorUserService userService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private TokenService service;

    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        //从Header获取token
       /* String token=request.getHeader("token");
        log.info("从头部获取的token==:{} ",token);*/

        //从url中获取username，再通过service获取token
        String uName = request.getParameter("uName");
        String token =null;
        if (null != uName && !"".equals(uName)) {
            token = service.getTokenByuName(uName);
        }
        log.info("从redis获取的uName==:{} ",uName);
        log.info("从redis获取的token==:{} ",token);
        //redis----------------start----------------
        try {
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
        }
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

            //redis中取得token并做判断
            ValueOperations<String,Object> vo = redisTemplate.opsForValue();
            Object loginStatus = vo.get(token);
            if( Objects.isNull(loginStatus)){
                JSONObject jsonResult  = new JSONObject();
                jsonResult.put("returnCode",500);
                jsonResult.put("returnMsg","token已经过期，请重新登录");
                response.getWriter().print(result);
                return false;
            }
            //重新赋值
            redisTemplate.expire(token,5, TimeUnit.MINUTES);
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

