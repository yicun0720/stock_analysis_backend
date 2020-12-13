package com.example.stock.DO;

import com.example.stock.Form.KLineRequestForm;
import lombok.Data;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 21:14
 */
@Data
public class KLineRequest {
    /**
     * 股票代码
     */
    private String code;

    private String fromDate;
    private String toDate;

    public KLineRequest() {
    }

    public KLineRequest(KLineRequestForm kLineRequestForm){
        this.code = kLineRequestForm.getCode();
        this.fromDate = kLineRequestForm.getFromDate();
        this.toDate = kLineRequestForm.getToDate();
    }
}
