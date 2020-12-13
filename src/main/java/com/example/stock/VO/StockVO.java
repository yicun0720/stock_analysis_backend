package com.example.stock.VO;

import lombok.Data;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 14:52
 */
@Data
public class StockVO {
    /**
     * 股票代码 key
     */
    private String code;

    private String name;
    private String enname;
    private String market;
    private String area;
    private String list_date;
}
