package com.twh.door.converter;

import com.twh.door.entity.DTO.DoorUserDTO;
import com.twh.door.entity.FORM.DoorUserForm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserFromToUserDTO {
    public static DoorUserDTO convert(DoorUserForm userForm) {
        //Gson gson = new Gson();
        DoorUserDTO userDTO = new DoorUserDTO();
        userDTO.setUserName(userForm.getUsername());
        userDTO.setPassWord(userForm.getPassword());
        userDTO.setFullName(userForm.getFullName());
        userDTO.setRemark(userForm.getRemark());
        userDTO.setAge(userForm.getAge());
        userDTO.setBornDate(userForm.getBornDate());
       /*
        List<ErpUser> userList = new ArrayList<>();
        try{
            userList = gson.fromJson(userForm.getUsername(), new TypeToken<List<ErpUser>>() {
            }.getType());
        }catch (Exception e){
            log.error("【对象转换】 错误，String={}", userForm.getUsername());
            throw new ErpException(ResultEnums.SYS_ERROR);
        }
        userDTO.setUserList(userList);*/
        return userDTO;
    }

}
