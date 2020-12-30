package com.example.stock;

import com.example.stock.Biz.DailyCostService;
import com.example.stock.DO.TradeVolumeStat;
import com.example.stock.VO.DailyTradeCostVO;
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
 * @ Date 2020/12/30 17:25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StockApplication.class)
public class DailyCostTest {
    @Autowired
    private DailyCostService dailyCostService;

    @Test
    public void testDailyTradeCost(){
        Object res = dailyCostService.getDailyTradeCost("000046", "2020-12-29").getContent();
        DailyTradeCostVO dailyTradeCostVO = (DailyTradeCostVO) res;
        List<TradeVolumeStat> statList = dailyTradeCostVO.getStatList();
        for(TradeVolumeStat tradeVolumeStat : statList){
            System.out.println(tradeVolumeStat);
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

}
