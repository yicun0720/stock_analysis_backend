package com.example.stock.Biz.BizImpl;

import com.example.stock.Biz.LargeTradeRecordService;
import com.example.stock.DO.KLineRequest_lb;
import com.example.stock.DO.TradeRecord;
import com.example.stock.Form.KLine;
import com.example.stock.Form.KLineRequestForm_lb;
import com.example.stock.Mapper.LargeTradeRecordMapper;
import com.example.stock.VO.ResponseVO;
import com.example.stock.VO.TradeRecordVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 18:50
 */
@Service
public class LargeTradeRecordServiceImpl implements LargeTradeRecordService {
    @Autowired
    private LargeTradeRecordMapper largeTradeRecordMapper;

    @Override
    public ResponseVO getKLineData_lb(KLineRequestForm_lb kLineRequestForm_lb){
        KLineRequest_lb kLineRequest_lb = new KLineRequest_lb(kLineRequestForm_lb);
        List<TradeRecord> tradeRecordList;

        KLine kLineType = kLineRequestForm_lb.getKLine();
        switch (kLineType){
            case K_5MIN:
                tradeRecordList = largeTradeRecordMapper.getTradeRecord_5min(kLineRequest_lb);
                break;
            case K_15MIN:
                tradeRecordList = largeTradeRecordMapper.getTradeRecord_15min(kLineRequest_lb);
                break;
            case K_30MIN:
                tradeRecordList = largeTradeRecordMapper.getTradeRecord_30min(kLineRequest_lb);
                break;
            case K_60MIN:
                tradeRecordList = largeTradeRecordMapper.getTradeRecord_60min(kLineRequest_lb);
                break;
            case K_1D:
                tradeRecordList = largeTradeRecordMapper.getTradeRecord_1d(kLineRequest_lb);
                break;
            default:
                return ResponseVO.buildFailure("未知K线类型");
        }
        List<TradeRecordVO> tradeRecordVOList = new ArrayList<>();
        for(TradeRecord tradeRecord: tradeRecordList){
            TradeRecordVO tradeRecordVO = new TradeRecordVO();
            BeanUtils.copyProperties(tradeRecord, tradeRecordVO);
            tradeRecordVOList.add(tradeRecordVO);
        }
        return ResponseVO.buildSuccess(tradeRecordVOList);
    }
}
