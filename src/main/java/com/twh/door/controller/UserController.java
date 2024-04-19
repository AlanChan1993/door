package com.twh.door.controller;


import com.twh.door.converter.UserFromToUserDTO;
import com.twh.door.entity.DTO.DoorUserDTO;
import com.twh.door.entity.POJO.DoorUser;
import com.twh.door.entity.VO.DoorUserVO;
import com.twh.door.entity.converter.DoorUserToDoorUserVO;
import com.twh.door.enums.ResultEnums;
import com.twh.door.entity.FORM.DoorUserForm;
import com.twh.door.entity.VO.ResultVO;
import com.twh.door.exception.DoorException;
import com.twh.door.services.impl.DoorUserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController    //相当于@Controller+@RequestBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private DoorUserServiceImpl userService;

    @ResponseBody
    @RequestMapping("getUserByName")
    public DoorUserVO getUser(String userName){
        DoorUser user = userService.getUserByUserName(userName);
        DoorUserVO doorUserVO = new DoorUserVO();
        if (null != user) {
            doorUserVO = new DoorUserToDoorUserVO().convert(user);
        }
        return doorUserVO;
    }

    @ResponseBody
    @RequestMapping("getUserListByName")
    public List<DoorUserVO> getUserList(@RequestParam("status")  String status){
        return userService.getUserList(status);
    }

    /**
     * 注册
     *
     * @param user 参数封装
     * @return Result
     */
    @PostMapping(value = "/regist")
    public ResultVO regist(@Valid DoorUserForm userFrom, BindingResult bindingResult) {
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
     *//*
    /*
    @PostMapping(value = "/login")
    public Result login(@Valid DoorUserForm userFrom, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【用户登录】 用户和密码不能空,user={}", userFrom);
            throw new DoorException(ResultEnums.NOT_NULL.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        DoorUserDTO userDTO = UserFromToUserDTO.convert(userFrom);

        return userService.login(userDTO);
    }
*/
}

