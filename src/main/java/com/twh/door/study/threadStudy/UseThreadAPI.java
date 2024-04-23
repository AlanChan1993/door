package com.twh.door.study.threadStudy;

public class UseThreadAPI {
        public static void main(String[] args) {
            // 线程如果没有指定名称,也有默认名称: Thread-数字 数字从0开始
            Thread t1 = new Thread();
            System.out.println(t1.getName());// Thread-0
            Thread t2 = new Thread();
            t2.setName("线程2"); // 修改线程名称
            System.out.println(t2.getName());
            // 通过构造方法执行线程名称: Thread(Stirng name)
            Thread t3 = new Thread("线程1");
            System.out.println(t3.getName());
            // 通过构造方法执行线程名称: Thread(Runnable r, String name)
            Thread t4 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("任务");
                }
            }, "线程3");
            System.out.println(t4.getName());

            // 获取main方法所在线程对象
            Thread t = Thread.currentThread();
            System.out.println(t.getName());
            // Exception in thread "main" 在一个叫main线程中出现了异常
            // System.out.println(1 / 0 );
        }

}
