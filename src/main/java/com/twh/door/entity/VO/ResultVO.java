package com.twh.door.entity.VO;

import lombok.Data;

/**
 * 向前端返回信息封装
 *
 * @param <T> 可变类型
 */
@Data
public class ResultVO<T> {
    //返回信息
    private String msg;
    //数据是否正常请求
    private boolean success;
    //具体返回的数据
    private T detail;
    //... getter and setter
}
