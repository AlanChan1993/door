package com.twh.door.enums;

import lombok.Getter;

@Getter
public enum ResultEnums {
    SUCCESS(0, "成功"),

    SYS_ERROR(1, "参数不正确"),

    PARM_NULL(2,"参数为空"),

    USER_NOT_EXIST(10, "用户不存在"),

    PASSWORD_NOT_EXIST(11, "密码不正确"),

    NOT_NULL(12, "用户密码不能为空"),

    CREATE_SUCCESS(13,"创建成员成功"),
    CREATE_FAIL(14,"创建成员成功"),

    SELECT_SUCCESS(15,"查询成功"),

    DEL_SUCCESS(16,"删除成功"),

    ;

    private Integer code;
    private String msg;

    ResultEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}