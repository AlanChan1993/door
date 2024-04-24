package com.twh.door.study.threadStudy.threadUtils;

import com.twh.door.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JavaThread extends Thread {
    @Override
    public void run(){
        log.info("【JavaThread.run】=:{}", new DateUtil().getNowDate());
        // 添加一个任务打印一百次:MyThread线程任务 ----
        for (int i = 1; i < 101; i++) {
            System.out.println("JavaThread线程任务 ---- " + i);
        }

    }
}
