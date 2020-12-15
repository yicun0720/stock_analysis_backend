package com.example.stock.DO;

import lombok.Data;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 14:42
 */
@Data
public class RatioVO {
    /**
     * 股票代码 key
     */
    private String code;
    private double price;
    private double ratio;
    public RatioVO(String code, double price, double ratio){
        this.code = code;
        this.price = price;
        this.ratio = ratio;
    }
}
