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

    public KLineRequestForm() {
    }

    public KLineRequestForm(KLineRequestForm_lb kLineRequestForm_lb){
        this.code = kLineRequestForm_lb.getCode();
        this.fromDate = kLineRequestForm_lb.getFromDate();
        this.toDate = kLineRequestForm_lb.getToDate();
        this.kLine = kLineRequestForm_lb.getKLine();
    }
}
