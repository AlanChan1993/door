package com.twh.door.utils.threadUtils;

public class JavaRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            System.out.println("【JavaRunnable任务对象】=" + i);
        }
    }
}
