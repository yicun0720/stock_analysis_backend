package com.example.stock.Mapper;

import com.example.stock.DO.KLineRequest_lb;
import com.example.stock.DO.TradeRecord;

import java.util.List;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 19:00
 */
public interface LargeTradeRecordMapper {

    List<TradeRecord> getTradeRecord_5min(KLineRequest_lb kLineRequest_lb);

    List<TradeRecord> getTradeRecord_15min(KLineRequest_lb kLineRequest_lb);

    List<TradeRecord> getTradeRecord_30min(KLineRequest_lb kLineRequest_lb);

    List<TradeRecord> getTradeRecord_60min(KLineRequest_lb kLineRequest_lb);

    List<TradeRecord> getTradeRecord_1d(KLineRequest_lb kLineRequest_lb);
}
