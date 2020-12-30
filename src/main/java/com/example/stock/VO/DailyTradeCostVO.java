package com.example.stock.VO;

import com.example.stock.DO.TradeVolumeStat;
import lombok.Data;

import java.util.List;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/30 17:21
 */
@Data
public class DailyTradeCostVO {
    private String code;

    private String tradeDate;

    private List<TradeVolumeStat> statList;


}
