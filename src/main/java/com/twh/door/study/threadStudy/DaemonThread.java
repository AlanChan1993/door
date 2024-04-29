package com.twh.door.study.threadStudy;

import ch.qos.logback.core.util.TimeUtil;

import java.util.concurrent.TimeUnit;

/**
 * 守护线程
 * 如果 JVM 中没有一个正在运行的非守护线程，这个时候，JVM 会退出。换句话说，守护线程拥有自动结束自己生命周期的特性，
 * 而非守护线程不具备这个特点。JVM 中的垃圾回收线程就是典型的守护线程，如果说不具备该特性，会发生什么呢？
 *当 JVM 要退出时，由于垃圾回收线程还在运行着，导致程序无法退出，这就很尴尬了！！！由此可见，守护线程的重要性了。
 *通常来说，守护线程经常被用来执行一些后台任务，但是呢，你又希望在程序退出时，或者说 JVM 退出时，线程能够自动关闭，
 * 此时，守护线程是你的首选。
 * */
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        //设置一个钩子线程，在JVM退出时输出日志
        Runtime.getRuntime().addShutdownHook(new Thread(()->System.out.println("THE JVM exit success !!!")));
        Thread thread=new Thread(()->{
            //模拟非守护线程不退出的情况
            while (true){
                try{
                    //睡眠一秒
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("I am runing ···");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);//设置为守护线程
        thread.start();//启动线程

        TimeUnit.SECONDS.sleep(2);
        //主线程即将推出
        System.out.println("The main thread ready to exit···");

    }
}
