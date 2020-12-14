package com.example.stock.Biz.BizImpl;

import com.example.stock.Biz.StockInfoService;
import com.example.stock.Biz.TradeRecordServiceForBl;
import com.example.stock.DO.News;
import com.example.stock.DO.Stock;
import com.example.stock.Mapper.NewsMapper;
import com.example.stock.Mapper.StockInfoMapper;
import com.example.stock.VO.NewsVO;
import com.example.stock.VO.ResponseVO;
import com.example.stock.VO.StockBaseInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 14:39
 */
@Service
public class StockInfoServiceImpl implements StockInfoService {

    private static final String NO_SUCH_STOCK_CODE_ERR = "股票代码不存在";

    @Autowired
    private StockInfoMapper stockInfoMapper;
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public ResponseVO getStockInfoByCode(String code){
        Stock stock = stockInfoMapper.getStockInfoByCode(code);
        if(stock != null){
            StockBaseInfoVO stockBaseInfoVO = new StockBaseInfoVO();
            BeanUtils.copyProperties(stock, stockBaseInfoVO);
            double percentRatio = (stock.getClose() - stock.getOpen()) / stock.getOpen();
            percentRatio *= 100.0;
            stockBaseInfoVO.setPercentRatio(percentRatio);

            return ResponseVO.buildSuccess(stockBaseInfoVO);
        }
        return ResponseVO.buildFailure(NO_SUCH_STOCK_CODE_ERR);
    }

    @Override
    public ResponseVO getStockNews(String fromTime, String toTime){
        List<News> newsList = newsMapper.getStockNews(fromTime, toTime);

        List<NewsVO> newsVOList = new ArrayList<>();
        for(News news: newsList){
            NewsVO newsVO = new NewsVO();
            BeanUtils.copyProperties(news, newsVO);
            newsVOList.add(newsVO);
        }

        return ResponseVO.buildSuccess(newsVOList);
    }
}
