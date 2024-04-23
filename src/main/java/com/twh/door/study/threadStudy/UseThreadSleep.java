package com.twh.door.study.threadStudy;

public class UseThreadSleep {
        public static void main(String[] args) {
            // 匿名内部类体现Thread子类
            Thread t1 = new Thread("线程1"){
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        try {
                            Thread.sleep(1000); // 只能try..catch处理异常,因为Thread中 run没有异常的声明,子类重写也不能声明异常
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(getName()+"----"+i);
                    }
                }
            };
            t1.start();
            // 匿名内部类提供Runnable的实现类
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 5; i++) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "----"+i);
                    }
                }
            }, "线程2");
            t2.start();
        }
}
