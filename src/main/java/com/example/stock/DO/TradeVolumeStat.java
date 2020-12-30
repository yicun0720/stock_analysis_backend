package com.example.stock.DO;

import lombok.Data;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/30 16:41
 */
@Data
public class TradeVolumeStat {
    /**
     * 价格
     */
    private double price;

    /**
     * 该价格下的成交量
     */
    private long volume;
}
