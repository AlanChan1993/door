package com.twh.door.study.threadStudy;

public class UseThreadDaemon {
        public static void main(String[] args) {

            Thread t = Thread.currentThread();
            boolean daemon = t.isDaemon();
            System.out.println(daemon ? "主线是守护线程" : "主线程不是守护线程");

            // 自己创建的线程对象,默认都不是守护线程.
            Thread t1 = new Thread("大王"){
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("我是大王我怕谁???");
                    }
                }
            };
            System.out.println("isDaemon=  " + t1.isDaemon());
            Thread t2 = new Thread("奴隶"){
                @Override
                public void run() {
                    while (true){
                        System.out.println("我是守护者,要为大王服务....");
                    }
                }
            };
            t2.setDaemon(true); // t2就变为守护线程了,就具备守护线程特点, 非守护线程任务结束了,
            // 那么这个守护线程过一会也会挂掉.
            System.out.println(t2.isDaemon());

            t1.start();
            t2.start();
        }
}
