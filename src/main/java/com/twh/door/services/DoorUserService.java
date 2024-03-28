package com.twh.door.services;

import com.twh.door.entity.DTO.DoorUserDTO;
import com.twh.door.entity.POJO.DoorUser;
import com.twh.door.entity.VO.Result;

public interface DoorUserService {
    DoorUser getUser(String userName, String passWord);

    Result login(DoorUserDTO user);

    Result regist(DoorUserDTO user);

    DoorUser getUserByUserName(String code);

}
