package com.twh.door.study;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JavaBasic {

    public void go(){

        long a = Runtime.getRuntime().freeMemory();//剩余空间的字节数
        long b = Runtime.getRuntime().totalMemory();//方法总内存的字节数，
        long c = Runtime.getRuntime().maxMemory();//返回最大内存的字节数。
        log.info("a=:{}", a);
    }
}
