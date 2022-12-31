package com.liboshuai.polaris.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: Bernardo
 * @Date: 2022/12/16 23:44
 * @Description:
 */
public class DateUtil {

    /** 日期对象转Long类型时间戳 */
    public static Long date2Long(Date date) {
        return date.getTime();
    }

    /** 时间戳转Date日期类型 */
    public static Date long2Date(Long timeStamp) {
        return new Date(timeStamp);
    }

    /** 日期转字符串 */
    public static String date2String(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /** 字符串转日期 */
    public static Date string2Date(String dateStr, String pattern) {
        // String dateStr="2018-3-15 14:26:00";
        // String pattern="yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /** Long时间戳转日期字符串 */
    public static String long2String(Long timeStamp) {
        Date date = new Date(timeStamp);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /** 日期字符串转Long时间戳 */
    public static Long string2Long(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }
}
