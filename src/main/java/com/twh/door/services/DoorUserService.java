package com.twh.door.services;

import com.twh.door.entity.DTO.DoorUserDTO;
import com.twh.door.entity.POJO.DoorUser;
import com.twh.door.entity.VO.DoorUserVO;
import com.twh.door.entity.VO.ResultVO;

import java.util.List;

public interface DoorUserService {
    DoorUser getUser(String userName, String passWord);

    ResultVO login(DoorUserDTO user);

    ResultVO regist(DoorUserDTO user);

    DoorUser getUserByUserName(String code);

    List<DoorUserVO> getUserList(String status);

    boolean createBySP(String name,String pwd,String fName);

}
