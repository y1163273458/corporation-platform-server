package com.example.corporationplatformserver.common.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SystemDateTime {
    public LocalDateTime getTime() {

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String localDateTime = df.format(time);
        LocalDateTime ldt = LocalDateTime.parse(localDateTime, df);
        return ldt;
    }

}
