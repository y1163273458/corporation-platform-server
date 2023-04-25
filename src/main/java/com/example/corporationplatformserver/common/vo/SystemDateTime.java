package com.example.corporationplatformserver.common.vo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class SystemDateTime {
    //用于生成当前时间
    public LocalDateTime getTime() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String localDateTime = df.format(time);
        LocalDateTime ldt = LocalDateTime.parse(localDateTime, df);
        return ldt;
    }

    //对前端发送回的时间进行格式化
    public LocalDateTime format(String time) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(time, df);
        return ldt;
    }

}
