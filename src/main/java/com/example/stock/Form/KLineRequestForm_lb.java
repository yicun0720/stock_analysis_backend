package com.example.stock.Form;

import lombok.Data;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 18:11
 */
@Data
public class KLineRequestForm_lb {
    /**
     * 股票代码
     */
    private String code;

    private String fromDate;
    private String toDate;

    /**
     * k线类型
     */
    private KLine kLine;

    /**
     * 股数过滤值
     */
    private int volumnThreshold;
}
