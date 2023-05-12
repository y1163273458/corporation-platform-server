package com.example.corporationplatformserver.common.util;

import com.example.corporationplatformserver.entity.Activity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.*;

public class Task {

    /**
     * 指定时间执行一次定时任务
     *
     * @param localDateTime 触发时机
     * @param timing        参数信息
     */
    public void timing(LocalDateTime localDateTime, Map<String, String> timing) {
        Calendar calendar = Calendar.getInstance();
        // 年份
        calendar.set(Calendar.YEAR, localDateTime.get(ChronoField.YEAR));
        // 月份 传入日期需要-1
        calendar.set(Calendar.MONTH, localDateTime.get(ChronoField.MONTH_OF_YEAR)-1);
        // 天数
        calendar.set(Calendar.DAY_OF_MONTH, localDateTime.get(ChronoField.DAY_OF_MONTH));
        // 小时
        calendar.set(Calendar.HOUR_OF_DAY, localDateTime.get(ChronoField.HOUR_OF_DAY));
        // 分钟
        calendar.set(Calendar.MINUTE, localDateTime.get(ChronoField.MINUTE_OF_HOUR));
        // 秒
        calendar.set(Calendar.SECOND, localDateTime.get(ChronoField.SECOND_OF_MINUTE));
        Date time = calendar.getTime();
        Timer timer = new Timer();
        // 执行
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行了指定执行时间任务，localDateTime:" + LocalDateTime.now());
                System.out.println("执行内容：" + timing.toString());
            }
        }, time);
    }
    public void create(Activity activity){
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 9, 28, 10, 14, 00);
        Map<String, String> timing1 = new HashMap<>();
        timing1.put("name", "timing1");
        new Task().timing(localDateTime1, timing1);
    }
}