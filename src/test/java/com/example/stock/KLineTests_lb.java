package com.example.stock;

import com.example.stock.Biz.LargeTradeRecordService;
import com.example.stock.Form.KLine;
import com.example.stock.Form.KLineRequestForm_lb;
import com.example.stock.VO.TradeRecordVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 20:05
 */
@SpringBootTest(classes = StockApplication.class)
public class KLineTests_lb {

    @Autowired
    private LargeTradeRecordService largeTradeRecordService;

    @Test
    public void testKLine_lb(){
        KLineRequestForm_lb kLineRequestForm_lb = new KLineRequestForm_lb();
        kLineRequestForm_lb.setCode("000046.SZ");
        kLineRequestForm_lb.setFromDate("2020-12-07 00:00:00");
        kLineRequestForm_lb.setToDate("2020-12-08 00:00:00");
        kLineRequestForm_lb.setKLine(KLine.K_5MIN);
        kLineRequestForm_lb.setVolumnThreshold(1000);

        Object res = largeTradeRecordService.getKLineData_lb(kLineRequestForm_lb).getContent();
        List<TradeRecordVO> tradeRecordVOArrayList = castList(res, TradeRecordVO.class);
        System.out.println(tradeRecordVOArrayList.size());
        System.out.println(tradeRecordVOArrayList.get(0));
//        for(TradeRecordVO tradeRecordVO: tradeRecordVOArrayList){
//
//        }
    }

    private static <T> List<T> castList(Object obj, Class<T> clazz){
        List<T> result = new ArrayList<T>();
        if(obj instanceof List<?>)
        {
            for (Object o : (List<?>) obj)
            {
                result.add(clazz.cast(o));
            }
            return result;
        }
        return null;
    }

    @Test
    public void testContrast(){
        KLineRequestForm_lb kLineRequestForm_lb = new KLineRequestForm_lb();
        kLineRequestForm_lb.setCode("000046.SZ");
        kLineRequestForm_lb.setFromDate("2020-12-03 00:00:00");
        kLineRequestForm_lb.setToDate("2020-12-04 00:00:00");
        kLineRequestForm_lb.setKLine(KLine.K_5MIN);
        kLineRequestForm_lb.setVolumnThreshold(1000);

        largeTradeRecordService.getContrastKLineData(kLineRequestForm_lb);
    }
}

