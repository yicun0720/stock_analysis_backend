package com.example.stock.Form;

import lombok.Data;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/30 17:09
 */
@Data
public class DailyCostRequestForm {
    /**
     * 股票代码
     */
    private String code;

    /**
     * 日期格式'yyyy-mm-dd'即可
     */
    private String tradeDate;
}
