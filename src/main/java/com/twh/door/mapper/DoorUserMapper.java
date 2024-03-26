package com.twh.door.mapper;


import com.twh.door.entity.DTO.DoorUserDTO;
import com.twh.door.entity.POJO.DoorUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * mapper的具体表达式
 */
@Mapper //标记mapper文件位置，否则在Application.class启动类上配置mapper包扫描
@Repository
public interface DoorUserMapper {

    /**
     * 查询用户名是否存在，若存在，不允许注册
     * 注解@Param(value) 若value与可变参数相同，注解可省略
     * 注解@Results  列名和字段名相同，注解可省略
     *
     * @param username
     * @return
     */
    @Results
            ({@Result(property = "username", column = "userName"),
                    @Result(property = "password", column = "passWord")})
    DoorUser findUserByName(@Param("userName") String username);

    /**
     * 注册  插入一条user记录
     *
     * @param user
     * @return
     */
    void regist(DoorUserDTO user);

    /**
     * 登录
     *
     * @param user
     * @return
     */
    Long login(DoorUserDTO user);
}

