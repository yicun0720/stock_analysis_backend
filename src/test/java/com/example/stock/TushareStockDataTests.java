package com.example.stock;

import com.example.stock.Biz.StockInfoService;
import com.example.stock.Biz.TushareStockDataService;
import com.example.stock.VO.NewsVO;
import com.example.stock.VO.ResponseVO;
import com.example.stock.VO.StockVO;
import com.example.stock.VO.TushareStockDataVO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
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
public class TushareStockDataTests {

    @Autowired
    private TushareStockDataService tushareStockDataService;

    @Test
    void testTushareStockData(){
        Object res = tushareStockDataService.getTushareStockData("trade_record_5","000046",1607403900, 1607410800);
        System.out.println(res);

        List<TushareStockDataVO> tushareStockDataVOList = castList(res, TushareStockDataVO.class);
        //assertEquals(5, tushareStockDataVOList.size(), "err num");
        for(TushareStockDataVO tushareStockDataVO: tushareStockDataVOList){
            System.out.println(tushareStockDataVO.getContent());
        }
        System.out.println("ffiinniisshheedd!!");
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
