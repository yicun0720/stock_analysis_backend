package com.example.stock.Biz;

import com.example.stock.Form.KLineRequestForm;
import com.example.stock.VO.ResponseVO;


/**
 * @ Description
 * @ Author CaoYang
 * @ Date 2020/12/13
 */
public interface TradeRecordService {
    /**
     * 获取一段时间内的某张表的某支股票的数据
     * @param kLineRequestForm
     * @return
     */
    ResponseVO getKLineData(KLineRequestForm kLineRequestForm);

    ResponseVO getAllStockDaily(String date);
}
