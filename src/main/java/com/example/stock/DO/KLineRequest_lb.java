package com.example.stock.DO;

import com.example.stock.Form.KLineRequestForm_lb;
import lombok.Data;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 18:54
 */
@Data
public class KLineRequest_lb {
    /**
     * 股票代码
     */
    private String code;

    private String fromDate;
    private String toDate;

    private int volumnThreshold;

    public KLineRequest_lb() {
    }

    public KLineRequest_lb(KLineRequestForm_lb kLineRequestForm_lb){
        this.code = kLineRequestForm_lb.getCode();
        this.fromDate = kLineRequestForm_lb.getFromDate();
        this.toDate = kLineRequestForm_lb.getToDate();
        this.volumnThreshold = kLineRequestForm_lb.getVolumnThreshold();
    }
}
