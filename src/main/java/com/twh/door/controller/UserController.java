package com.twh.door.controller;


import com.twh.door.converter.UserFromToUserDTO;
import com.twh.door.entity.DTO.DoorUserDTO;
import com.twh.door.entity.POJO.DoorUser;
import com.twh.door.enums.ResultEnums;
import com.twh.door.entity.FORM.DoorUserForm;
import com.twh.door.entity.VO.Result;
import com.twh.door.exception.DoorException;
import com.twh.door.services.DoorUserServiceImpl;
import com.twh.door.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@RestController    //相当于@Controller+@RequestBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private DoorUserServiceImpl userService;

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
            throw new DoorException(ResultEnums.NOT_NULL.getCode(), bindingResult.getFieldError().getDefaultMessage());
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
            throw new DoorException(ResultEnums.NOT_NULL.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        DoorUserDTO userDTO = UserFromToUserDTO.convert(userFrom);

        return userService.login(userDTO);
    }

}

