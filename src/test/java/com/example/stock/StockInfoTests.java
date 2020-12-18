package com.example.stock;

import com.example.stock.Biz.StockInfoService;
import com.example.stock.VO.NewsVO;
import com.example.stock.VO.StockBaseInfoVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 15:17
 */
@SpringBootTest(classes = StockApplication.class)
public class StockInfoTests {

    @Autowired
    private StockInfoService stockInfoService;

    @Test
    public void testInfo(){
        StockBaseInfoVO stockVO = (StockBaseInfoVO) stockInfoService.getStockInfoByCode("000046").getContent();
        System.out.println(stockVO);
        assertEquals("19940912", stockVO.getList_date(), "err" + stockVO.getList_date());
    }
    @Test
    public void testNews(){
        Object res = stockInfoService.getStockNews("2020-12-07 13:07:20", "2020-12-07 13:19:00").getContent();
        List<NewsVO> newsVOList = castList(res, NewsVO.class);
        assertEquals(5, newsVOList.size());
        for(NewsVO newsVO: newsVOList){
            System.out.println(newsVO.getContent());
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
