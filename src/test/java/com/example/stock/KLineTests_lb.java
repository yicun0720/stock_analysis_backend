package com.example.stock;

import com.example.stock.Biz.LargeTradeRecordService;
import com.example.stock.DO.TradeRecord;
import com.example.stock.Form.KLine;
import com.example.stock.Form.KLineRequestForm_lb;
import com.example.stock.VO.TradeRecordVO;
import com.example.stock.VO.TwoRecordList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 20:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StockApplication.class)
public class KLineTests_lb {

    @Autowired
    private LargeTradeRecordService largeTradeRecordService;

    @Test
    public void testKLine_lb(){
        KLineRequestForm_lb kLineRequestForm_lb = new KLineRequestForm_lb();
        kLineRequestForm_lb.setCode("000046");
        kLineRequestForm_lb.setFromDate("2020-12-13 00:00:00");
        kLineRequestForm_lb.setToDate("2020-12-14 00:00:00");
        kLineRequestForm_lb.setKLine(KLine.K_5MIN);
        kLineRequestForm_lb.setVolumnThreshold(1000);

        Object res = largeTradeRecordService.getKLineData_lb(kLineRequestForm_lb).getContent();
        List<TradeRecordVO> tradeRecordVOArrayList = castList(res, TradeRecordVO.class);
        System.out.println(tradeRecordVOArrayList.size());
        System.out.println(tradeRecordVOArrayList.get(0));
        for(TradeRecordVO tradeRecordVO: tradeRecordVOArrayList){
            System.out.println(tradeRecordVO.getDate());
        }
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
        kLineRequestForm_lb.setCode("000046");
        kLineRequestForm_lb.setFromDate("2020-12-20 00:00:00");
        kLineRequestForm_lb.setToDate("2021-01-07 20:00:00");
        kLineRequestForm_lb.setKLine(KLine.K_1D);
        kLineRequestForm_lb.setVolumnThreshold(1000);

        Object res = largeTradeRecordService.getContrastKLineData(kLineRequestForm_lb).getContent();
        TwoRecordList twoRecordList = (TwoRecordList)res;
        System.out.println(twoRecordList.getTr_list_lb().size()+" "+twoRecordList.getTr_list_origin().size());
        for(int i = 0;i<twoRecordList.getTr_list_lb().size();i++){
            System.out.println(twoRecordList.getTr_list_lb().get(i).getDate()+" "+twoRecordList.getTr_list_origin().get(i).getDate());
        }
    }
}

