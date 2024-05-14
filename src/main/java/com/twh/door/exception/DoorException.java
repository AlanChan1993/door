package com.twh.door.exception;


import com.twh.door.enums.ResultEnums;

public class DoorException extends RuntimeException {
    private Integer code;

    public DoorException(ResultEnums resultEnums) {
        super(resultEnums.getMsg());
        this.code = resultEnums.getCode();
    }

    public DoorException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public DoorException(String message) {
    }
}