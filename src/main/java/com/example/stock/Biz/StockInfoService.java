package com.example.stock.Biz;

import com.example.stock.VO.ResponseVO;

import javax.xml.ws.Response;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 14:35
 */
public interface StockInfoService {
    /**
     * 股票基本信息
     * @param code
     * @return
     */
    ResponseVO getStockInfoByCode(String code);

    /**
     * 获取一段时间内的新闻
     * @param fromTime
     * @param toTime
     * @return
     */
    ResponseVO getStockNews(String fromTime, String toTime);
}
