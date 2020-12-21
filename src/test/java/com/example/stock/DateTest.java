package com.example.stock;

import com.example.stock.Utils.DateUtil;
import com.example.stock.Utils.UtilDO.DateTimeRange;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/21 18:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StockApplication.class)
public class DateTest {

    @Test
    public void testDate(){
        Calendar calendar = Calendar.getInstance();
        String dateStr = "2020-12-20 18:07:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse(dateStr);
            calendar.setTime(date);
        }catch (ParseException e){
            e.printStackTrace();
        }
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        while(day == 7 || day == 1){
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            day = calendar.get(Calendar.DAY_OF_WEEK);
        }
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar.getTime());
        System.out.println(simpleDateFormat.format(calendar.getTime()));
    }

    @Test
    public void test2(){
        String fromDate = "2020-12-18 18:00:00";
        String toDate = "2020-12-20 18:00:00";
        DateTimeRange dateTimeRange = DateUtil.parseDateToNearestWorkday(fromDate, toDate);
        if(dateTimeRange == null){
            return;
        }
        fromDate = dateTimeRange.getFromDateTime();
        toDate = dateTimeRange.getToDateTime();
        System.out.println(fromDate);
        System.out.println(toDate);
    }
}
