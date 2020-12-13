package com.example.stock.VO;

import lombok.Data;

/**
 * @ Description
 * @ Author CaoYang
 * @ Date 2020/12/13
 */
@Data
public class TushareStockDataVO {
    private String ts_code;
    private String date_str;
    private float open;
    private float high;
    private float low;
    private float close;

    public String getContent() {
        return ts_code+" "+date_str+" "+open+" "+high+" "+low+" "+close;
    }
}
