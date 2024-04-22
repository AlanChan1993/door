package com.twh.door.study;

import com.twh.door.utils.DateUtil;
import com.twh.door.utils.JavaThread;
import com.twh.door.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UseThread {
    public static void main(String[] args) {
        // System.out.println( 1 / 0);
        // 创建一个MyThread对象
        JavaThread mt = new JavaThread();
        // 调用start方法开启线程
        mt.start();
        // mt.run(); 千万不要调用run方法,因为并没有开启线程,只是一个对象调用一次方法而已.
        // 这个循环属于main方法所在的线程,就是换一个叫做"main"线程,这线程就是主线程
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程中的任务---" + i);
        }

        // 匿名内部方式继承Thread类开启多线程
        Thread t = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("线程1-----"+i);
                }
            }
        };
        t.start();
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("线程2-----"+i);
                }
            }
        }.start();

    }
}
