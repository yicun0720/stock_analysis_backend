package com.example.stock.VO;

import lombok.Data;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 19:27
 */
@Data
public class TradeRecordVO {
    private String code;
    private String date;

    private double open;
    private double high;
    private double low;
    private double close;

    private int volumnThreshold;
}
