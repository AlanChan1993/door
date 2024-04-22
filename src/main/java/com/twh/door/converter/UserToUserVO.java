package com.twh.door.converter;

import com.twh.door.entity.POJO.DoorUser;
import com.twh.door.entity.VO.DoorUserVO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserToUserVO {
    public DoorUserVO convert(DoorUser user) {
        DoorUserVO vo = new DoorUserVO();
        vo.setUserName(user.getUserName());
        vo.setRemark(user.getRemark());
        vo.setPassWord(user.getPassWord());
        vo.setId(user.getId());
        vo.setFullName(user.getFullName());
        vo.setBornDate(user.getBornDate());
        vo.setAge(user.getAge());
        return vo;
    }

    public List<DoorUserVO> convertListNew(List<DoorUser> userList) {
        return userList.stream().map(e -> convert(e)).collect(Collectors.toList());
    }

    public List<DoorUserVO> convertList(List<DoorUser> userList) {
        List<DoorUserVO> voList = new ArrayList<>();
        for (DoorUser user:userList){
            DoorUserVO vo = new DoorUserVO();
            vo.setUserName(user.getUserName());
            vo.setRemark(user.getRemark());
            //vo.setPassWord();
            vo.setId(user.getId());
            vo.setFullName(user.getFullName());
            vo.setBornDate(user.getBornDate());
            vo.setAge(user.getAge());
            voList.add(vo);
        }
        return voList;
    }
}
