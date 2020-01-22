package dz.trash.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public  class ConfigDate {
    public static  Date configure(Integer year,Integer month,Integer day){
        year = year == null ? 2015 : year;
        month = month == null ? 10 : month;
        day = day == null ? 29 : day;

        return Date.valueOf(LocalDate.of(year,month,day));
    }
    public static Timestamp configure(Integer year, Integer month, Integer day,Integer hour,Integer min,Integer sec){
        year = year == null ? 2015 : year;
        month = month == null ? 10 : month;
        day = day == null ? 29 : day;
        hour = hour == null ? 12 : hour;
        min = min == null ? 30 : min;
        sec = sec == null ? 15 : sec;

        return Timestamp.valueOf(LocalDateTime.of(year,month,day,hour,min,sec));
    }
}
