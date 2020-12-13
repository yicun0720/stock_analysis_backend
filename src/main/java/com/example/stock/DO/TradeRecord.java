package com.example.stock.DO;

import lombok.Data;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 19:02
 */
@Data
public class TradeRecord {

    private String code;
    private String date;

    private double open;
    private double high;
    private double low;
    private double close;

//    private double open_100;
//    private double high_100;
//    private double low_100;
//    private double close_100;
//
//    private double open_1000;
//    private double high_1000;
//    private double low_1000;
//    private double close_1000;

    private int volumnThreshold;
}
