package com.example.stock.DO;

import lombok.Data;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 14:42
 */
@Data
public class Stock {
    /**
     * 股票代码 key
     */
    private String code;

    private String name;
    private String enname;
    private String market;
    private String area;
    private String list_date;

    /**
     * 涨跌情况
     */
    private double open;
    private double high;
    private double low;
    private double close;

    private String date;

}
