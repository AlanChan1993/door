package com.twh.door.timer;

import com.twh.door.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Slf4j
@Component
public class TimerProgram {
    @Value("${timer.TimerProgram.timerStr}")
    private String timerStr;

    /**
     * 每30s处理一次   1000 * 1 * 30
     */
    @Scheduled(cron="0 0 4 * * ?")//凌晨4点执行
    @Scheduled(fixedRate = 1000 * 1 * 30)
    private void doTimer(){
        log.info("【TimerProgram.doTimer】timerStr=:{}", timerStr);
        log.info("【TimerProgram.doTimer】getNowDate=:{}", new DateUtil().getNowDate());
        log.info("【TimerProgram.doTimer】getNowDate2=:{}", new DateUtil().getNowDate2());
    }


}
