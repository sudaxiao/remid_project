package com.dfire.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  时间转换
 * Created by xiaosuda on 2017/9/8.
 */
public class DateTimeTransUtil {

    private static final DateFormat DATETIME_FORMAT= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    /**
     *  字符串时间转换为毫秒级
     * @param time  字符串时间格式  1970-01-01 06:00:00
     * @return
     */
    public static Long datetimeStringToLong(String time){
        Long longTime=0L;

        try {
            longTime = DATETIME_FORMAT.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return longTime;
    }

    /**
     *  毫秒时间转换为具体时间
     * @param time  毫秒级时间
     * @return
     */
    public static String dateTimeLongToString(Long time){
        return DATETIME_FORMAT.format(new Date(time));
    }
}
