package com.example.stock.Biz;

import com.example.stock.Form.KLineRequestForm_lb;
import com.example.stock.VO.ResponseVO;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 18:47
 */
public interface LargeTradeRecordService {
    /**
     * 大单交易K线数据
     * @param kLineRequestForm_lb
     * @return
     */
    ResponseVO getKLineData_lb(KLineRequestForm_lb kLineRequestForm_lb);

}
