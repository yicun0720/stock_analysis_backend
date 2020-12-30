package com.example.stock.Biz.BizImpl;

import com.example.stock.Biz.DailyCostService;
import com.example.stock.DO.TradeVolumeStat;
import com.example.stock.Mapper.DailyCostMapper;
import com.example.stock.Utils.DateUtil;
import com.example.stock.VO.DailyTradeCostVO;
import com.example.stock.VO.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/30 17:14
 */
@Service
public class DailyCostServiceImpl implements DailyCostService {
    @Autowired
    private DailyCostMapper dailyCostMapper;

    @Override
    public ResponseVO getDailyTradeCost(String code, String tradeDate){
        tradeDate = DateUtil.parseSingleDateToNearestWorkday(tradeDate);
        if(tradeDate == null){
            return ResponseVO.buildFailure("日期格式错误");
        }

        List<TradeVolumeStat> statList = dailyCostMapper.getDailyCostByCodeAndDate(code, tradeDate);
        if(statList == null || statList.size() == 0){
            return ResponseVO.buildFailure("暂无股票代码" + code + "于" + tradeDate + "的交易数据");
        }

        DailyTradeCostVO dailyTradeCostVO = new DailyTradeCostVO();
        dailyTradeCostVO.setCode(code);
        dailyTradeCostVO.setTradeDate(tradeDate);
        dailyTradeCostVO.setStatList(statList);

        return ResponseVO.buildSuccess(dailyTradeCostVO);
    }

}
