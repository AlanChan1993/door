package com.twh.door.study;

import com.twh.door.utils.JavaRunnable;

public class UseRunnable {
    public static void main(String[] args) {
        JavaRunnable javaRunnable = new JavaRunnable();
        Thread a = new Thread(javaRunnable);
        a.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("【UseRunnable主线程】=" + i);
        }
    }
}
