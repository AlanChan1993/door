package com.twh.door.services;

import com.twh.door.entity.DTO.DoorUserDTO;
import com.twh.door.entity.POJO.DoorUser;
import com.twh.door.entity.VO.Result;
import com.twh.door.mapper.DoorUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class DoorUserService {

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
}

