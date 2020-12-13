package com.example.stock.Form;

import lombok.Data;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 16:07
 */
@Data
public class KLineRequestForm {

    private String code;
    private String fromDate;
    private String toDate;
    /**
     * k线类型
     */
    private KLine kLine;

}
