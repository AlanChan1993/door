package com.twh.door.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Slf4j
public class SomeTimeUtils {

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        log.info("date=:{}", dateFormat.format(date));

        SimpleDateFormat dateFormat2 = new SimpleDateFormat("YYYYMMddhhmmss");
        log.info("date=:{}", dateFormat2.format(date));

        SimpleDateFormat dateFormat3 = new SimpleDateFormat("YYYY-MM-dd");
        log.info("date=:{}", dateFormat3.format(date));

        SimpleDateFormat dateFormat4 = new SimpleDateFormat("ss:mm:hh dd-MM-YYYY");
        log.info("date=:{}", dateFormat4.format(date));

        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar calendar = Calendar.getInstance();
        String dateName = df.format(calendar.getTime());
        log.info("dateName=:{}", dateName);

        //获取默为当前时间的Calendar日期对象
        Calendar c = Calendar.getInstance();
        //格式化日期输出当前日期
        System.out.printf("%tF %<tT%n",c);
        log.info(df.format(c.getTime()));

        //加五天
        c.add(Calendar.DATE,5);
        System.out.printf("%tF %<tT%n",c);

        //在加五天的基础上减10天
        c.add(Calendar.DATE,-10);
        System.out.printf("%tF %<tT%n",c);

        //清除日期
        c.clear();
        System.out.printf("%tF %<tT%n",c);
    }

}
