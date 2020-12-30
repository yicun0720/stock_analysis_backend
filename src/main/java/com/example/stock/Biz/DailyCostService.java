package com.example.stock.Biz;

import com.example.stock.VO.ResponseVO;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/30 17:05
 */
public interface DailyCostService {

    /**
     * 获取成本计算数据
     * @param code
     * @param tradeDate
     * @return
     */
    ResponseVO getDailyTradeCost(String code, String tradeDate);

}
