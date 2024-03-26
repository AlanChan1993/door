package com.twh.door.entity.EMUNS;

import lombok.Getter;

@Getter
public enum ResultEnums {
    SUCCESS(0, "成功"),

    SYS_ERROR(1, "参数不正确"),

    USER_NOT_EXIST(10, "用户不存在"),

    PASSWORD_NOT_EXIST(11, "密码不正确"),

    NOT_NULL(12, "用户密码不能为空"),

    ;

    private Integer code;
    private String msg;

    ResultEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}