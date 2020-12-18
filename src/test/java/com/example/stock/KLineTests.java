package com.example.stock;

import com.example.stock.Biz.TradeRecordService;
import com.example.stock.DO.RatioVO;
import com.example.stock.Form.KLine;
import com.example.stock.Form.KLineRequestForm;
import com.example.stock.VO.TradeRecordVO;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 15:17
 */
@SpringBootTest(classes = StockApplication.class)
public class KLineTests {

    @Autowired
    private TradeRecordService tradeRecordService;

    @Test
    void testKLine(){
        KLineRequestForm kLineRequestForm = new KLineRequestForm();
        kLineRequestForm.setCode("000046");
        kLineRequestForm.setFromDate("2020-01-02");
        kLineRequestForm.setToDate("2020-01-03");
        kLineRequestForm.setKLine(KLine.K_1D);

        Object res = tradeRecordService.getKLineData(kLineRequestForm).getContent();
        List<TradeRecordVO> tradeRecordVOArrayList = castList(res, TradeRecordVO.class);
        System.out.println(tradeRecordVOArrayList.size());
        for(TradeRecordVO tradeRecordVO: tradeRecordVOArrayList){
            System.out.println(tradeRecordVO);
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
    void testAllStockDaily(){
        Object res = tradeRecordService.getAllStockDaily("2020-01-03").getContent();
        List<RatioVO> ratioVOArrayList = castList(res, RatioVO.class);
        System.out.println(ratioVOArrayList.size());
        for(RatioVO ratioVO: ratioVOArrayList){
            System.out.println(ratioVO);
        }

    }
}
