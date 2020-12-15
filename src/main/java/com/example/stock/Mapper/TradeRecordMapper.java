package com.example.stock.Mapper;

import com.example.stock.DO.KLineRequest;
import com.example.stock.DO.TradeRecord;

import java.util.List;

/**
 * @ Description
 * @ Author CaoYang
 * @ Date 2020/12/13
 */

public interface TradeRecordMapper {

    List<TradeRecord> getTradeRecord_5min(KLineRequest kLineRequest);

    List<TradeRecord> getTradeRecord_15min(KLineRequest kLineRequest);

    List<TradeRecord> getTradeRecord_30min(KLineRequest kLineRequest);

    List<TradeRecord> getTradeRecord_60min(KLineRequest kLineRequest);

    List<TradeRecord> getTradeRecord_1d(KLineRequest kLineRequest);

    List<TradeRecord> getAllStockDaily(String date);
}
