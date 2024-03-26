package com.twh.door.entity.POJO;

import lombok.Data;

import java.util.Date;

@Data
public class DoorUser {
    private long id;
    private String userName;
    private String fullName;
    private String passWord;
    private String Status;
    private Date createTime;
    private String remark;
    private Date updateTime;
    private Integer age;
    private String bornDate;
    private String resource;
}
