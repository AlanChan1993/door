package com.twh.door.controller;

import com.twh.door.entity.FORM.DoorUserForm;
import com.twh.door.entity.POJO.DoorUser;
import com.twh.door.entity.VO.Result;
import com.twh.door.services.DoorUserServiceImpl;
import com.twh.door.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
@Slf4j
@RequestMapping("/Check")
public class Checkcontroller {
    @Autowired
    private DoorUserServiceImpl userservice;

    @Autowired
    private RedisTemplate redisTemplate;

    //之前用的check，可能check为关键字
    @RequestMapping("/login")
    public String show(){
        return "/door/check.html";
    }

    @PostMapping("/login2")
    //这里不能写Get(因为要与前端页面中的方法保持一致)，可以使用PostMapping或者RequestMapping（支持Get和Post）
    public String checkin(@Valid DoorUserForm userFrom, HttpServletRequest request,
                          HttpServletResponse response){//@Pattern(regexp = "^\\S{5,16}$") String username
        DoorUser user = userservice.getUser(userFrom.getUsername(), userFrom.getPassword());
        if(user!=null){
            //session.setAttribute("loginuser","username");
            DoorUser userBean = userservice.getUser(userFrom.getUsername(), userFrom.getPassword());
            String token = TokenUtils.generateToken(userBean);
            log.info("生成的token=:{}", token);

            // 将 token 存储到 redis 中
            //ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            //operations.set(token, token, 1, TimeUnit.HOURS);
            ValueOperations<String, String> vo = redisTemplate.opsForValue();
            vo.set(token, userFrom.getUsername(), 5, TimeUnit.MINUTES);

            response.setHeader("token", token);
            response.addHeader("Authorization", "Twh_ " + token);
            return "redirect:/door/home/bingo.html";
        }else{
            return "redirect:/door/error.html";
            //账号或密码错误，登录失败，重定向到登录页面
        }
    }

/*
	//也可以用get，url传参（记得修改前端的传参方式）
    @GetMapping("/login2/{name}/{password}")
    //这里不能用Get，可以使用PostMapping或者RequestMapping（支持Get和Post）
    public String checkin(@PathVariable("name") String name, @PathVariable("password") String password,
                          HttpSession session){
        User user= servicemapper.getUser(name,password);
        if(user!=null){
            session.setAttribute("loginuser","username");
            return "redirect:/bingo";
        }else{
            return "redirect:/login";
            //账号或密码错误，登录失败，重定向到登录页面
        }
    }
    */

    @GetMapping("/logout")
    //之前使用的是@PostMapping("/logout"),报错
    public String logout(HttpSession session, HttpServletRequest request,
                         HttpServletResponse response){
        session.removeAttribute("loginuser");
        //response.setHeader("token", token);
        return "redirect:/door/check.html";
    }

    //todo
    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String, String> params, @RequestHeader("Authorization") String token) {
        // 校验参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");

        if (!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)) {
            //return Result.error("缺少必要的参数");
        }
        //Map<String, Object> map = ThreadLocalUtil.get();
        String username = null; //(String) map.get("username");
        DoorUser loginUser = userservice.getUserByUserName(username);
        if (1>1) {//!loginUser.getPassword().equals(Md5Util.getMD5String(oldPwd)
            //return Result.error("原密码不正确");
        }
        if (!rePwd.equals(newPwd)) {
            //return Result.error("两次填写的密码不正确");
        }
        // service
        //userService.updatePwd(newPwd);
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.getOperations().delete(token);
        return new Result();//Result.success();
    }

}

