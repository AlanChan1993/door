package com.twh.door.study;

import com.twh.door.utils.JavaCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class UseCallable {
        public static void main(String[] args) throws ExecutionException, InterruptedException {
            // 3.MyCallable对象
            JavaCallable mc = new JavaCallable();
            // 4.创建一个FutureTask对象, 把MyCallable绑定到未来任务对象中
            FutureTask<String> task = new FutureTask<>(mc);

            // 5.把未来任务对象绑定到Thread类中
            Thread t = new Thread(task);
            t.start();
            for (int i = 0; i < 100; i++) {
                System.out.println("主线程-女生不要答应");
            }
            // 一定要在线程开启之后,在调用get方法,否则线程就没有开启的机会.
            String result = task.get();
            System.out.println("女神的反馈:"+result);
        }
}
