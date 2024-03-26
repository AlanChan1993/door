package com.twh.door.entity.FORM;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class DoorUserForm {
    //@NotEmpty(message = "用户名必填")
    private String username;
    //@NotEmpty(message = "密码必填")
    private String password;
    private String fullName;
    private String remark;
    private Integer age;
    private String bornDate;
}
