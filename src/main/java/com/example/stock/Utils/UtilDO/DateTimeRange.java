package com.example.stock.Utils.UtilDO;

import lombok.Data;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/21 18:54
 */
@Data
public class DateTimeRange {
    private String fromDateTime;
    private String toDateTime;

    public DateTimeRange(String fromDateTime, String toDateTime) {
        this.fromDateTime = fromDateTime;
        this.toDateTime = toDateTime;
    }

}
