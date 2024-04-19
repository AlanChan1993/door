package com.twh.door.entity.converter;

import com.twh.door.entity.POJO.DoorUser;
import com.twh.door.entity.VO.DoorUserVO;

public class DoorUserToDoorUserVO {

    public DoorUserVO convert(DoorUser user){
        DoorUserVO userVO = new DoorUserVO();
        userVO.setAge(user.getAge());
        userVO.setBornDate(user.getBornDate());
        userVO.setFullName(user.getFullName());
        userVO.setId(user.getId());
        userVO.setPassWord(user.getPassWord());
        userVO.setRemark(user.getRemark());
        userVO.setUserName(user.getUserName());
        return userVO;
    }

}
