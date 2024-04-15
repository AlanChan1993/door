package com.twh.door.services.impl;

import cn.hutool.core.util.RandomUtil;
import com.twh.door.entity.DTO.DoorUserDTO;
import com.twh.door.entity.POJO.DoorUser;
import com.twh.door.entity.VO.Result;
import com.twh.door.mapper.DoorUserMapper;
import com.twh.door.services.DoorUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
@Slf4j
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class DoorUserServiceImpl implements DoorUserService {

    @Autowired
    private DoorUserMapper userMapper;

    /**
     * 注册
     *
     * @param user 参数封装
     * @return Result
     */
    public Result regist(DoorUserDTO user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            DoorUser existUser = userMapper.findUserByName(user.getUserName());
            if (existUser != null) {
                //如果用户名已存在
                result.setMsg("用户名已存在");

            } else {
                userMapper.regist(user);
                //System.out.println(user.getId());
                result.setMsg("注册成功");
                result.setSuccess(true);
                result.setDetail(user);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public DoorUser getUserByUserName(String code) {
        return userMapper.findUserByName(code);
    }

    /**
     * 登录
     *
     * @param user 用户名和密码
     * @return Result
     */
    public Result login(DoorUserDTO user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            Long userId = userMapper.login(user);
            if (userId == null) {
                result.setMsg("用户名或密码错误");
            } else {
                result.setMsg("登录成功");
                result.setSuccess(true);
                user.setId(userId);
                result.setDetail(user);
            }

        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public DoorUser getUser(String userName, String passWord) {
        return userMapper.getUser(userName,passWord);
    }


}

