package com.twh.door.entity.exception;


import com.twh.door.entity.EMUNS.ResultEnums;

public class doorException extends RuntimeException {
    private Integer code;

    public doorException(ResultEnums resultEnums) {
        super(resultEnums.getMsg());
        this.code = resultEnums.getCode();
    }

    public doorException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}