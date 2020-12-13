package com.example.stock.Form;

import lombok.Data;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 16:07
 */
@Data
public class TushareStockDataForm {
    private String schema;
    private String ts_code;
    private int fromTime;
    private int toTime;

    public int getFromTime() {
        return fromTime;
    }

    public String getSchema() {
        return schema;
    }

    public int getToTime() {
        return toTime;
    }

    public String getTs_code() {
        return ts_code;
    }
}
