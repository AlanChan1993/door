package com.twh.door.controller;


import com.twh.door.converter.UserFromToUserDTO;
import com.twh.door.entity.DTO.DoorUserDTO;
import com.twh.door.entity.EMUNS.ResultEnums;
import com.twh.door.entity.FORM.DoorUserForm;
import com.twh.door.entity.VO.Result;
import com.twh.door.entity.exception.doorException;
import com.twh.door.services.DoorUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController    //相当于@Controller+@RequestBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private DoorUserService userService;

    /**
     * 注册
     *
     * @param user 参数封装
     * @return Result
     */
    @PostMapping(value = "/regist")
    public Result regist(@Valid DoorUserForm userFrom, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【用户注册】 用户和密码不能空,user={}", userFrom);
            throw new doorException(ResultEnums.NOT_NULL.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        DoorUserDTO userDTO = UserFromToUserDTO.convert(userFrom);
        return userService.regist(userDTO);
    }

    /**
     * 登录
     *
     * @param user 参数封装
     * @return Result
     */
    @PostMapping(value = "/login")
    public Result login(@Valid DoorUserForm userFrom, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【用户登录】 用户和密码不能空,user={}", userFrom);
            throw new doorException(ResultEnums.NOT_NULL.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        DoorUserDTO userDTO = UserFromToUserDTO.convert(userFrom);
        return userService.login(userDTO);
    }

}

