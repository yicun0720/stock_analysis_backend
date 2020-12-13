package com.example.stock.Biz;

import com.example.stock.DO.TradeRecord;
import com.example.stock.Form.KLineRequestForm;

import java.util.List;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 22:17
 */
public interface TradeRecordServiceForBl {

    List<TradeRecord> getKLineDataForContrast(KLineRequestForm kLineRequestForm);

}
