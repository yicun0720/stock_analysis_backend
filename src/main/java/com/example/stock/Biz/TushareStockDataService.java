package com.example.stock.Biz;

import com.example.stock.VO.ResponseVO;

import javax.xml.ws.Response;

/**
 * @ Description
 * @ Author CaoYang
 * @ Date 2020/12/13
 */
public interface TushareStockDataService {
    /**
     * 获取一段时间内的某张表的某支股票的数据
     * @param schema
     * @param ts_code
     * @param fromTime
     * @param toTime
     * @return
     */
    ResponseVO getTushareStockData(String schema, String ts_code, int fromTime, int toTime);
}
