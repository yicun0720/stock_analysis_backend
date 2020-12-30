package com.example.stock.Utils;

import com.example.stock.Utils.UtilDO.DateTimeRange;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/21 18:40
 */
public class DateUtil {
    /**
     * yyyy-MM-dd 格式的日期，处理单个时间至最近的一个工作日
     */
    public static String parseSingleDateToNearestWorkday(String dateTime){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = simpleDateFormat.parse(dateTime);
            calendar.setTime(date);
        }catch (ParseException e){
            e.printStackTrace();
            return null;
        }
        while(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
                || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        return simpleDateFormat.format(calendar.getTime());
    }
    /**
     * yyyy-MM-dd HH-mm-ss格式的日期，处理时间段，toDateTime至最近的一个工作日
     */
    public static DateTimeRange parseDateToNearestWorkday(String fromDateTime, String toDateTime){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse(toDateTime);
            calendar.setTime(date);
        }catch (ParseException e){
            e.printStackTrace();
            return null;
        }
        int count = 0;
        while(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
                || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            count++;
        }
        DateTimeRange dateTimeRange =
                new DateTimeRange(decreaseDayByNum(fromDateTime, count), simpleDateFormat.format(calendar.getTime()));
        return dateTimeRange;
    }

    private static String decreaseDayByNum(String dateTime, int num){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse(dateTime);
            calendar.setTime(date);
        }catch (ParseException e){
            e.printStackTrace();
        }
        calendar.add(Calendar.DAY_OF_MONTH, -num);
        return simpleDateFormat.format(calendar.getTime());
    }

    /**
     * yyyy-MM-dd hh:mm:ss ->yyyy-MM-dd
     * @param dateTime
     * @return
     */
    public static String fetchDateFromDateTime(String dateTime){
        return dateTime.substring(0, 10);
    }
}
