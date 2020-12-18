package com.example.stock.Controller;

import com.example.stock.Biz.LargeTradeRecordService;
import com.example.stock.Form.KLineRequestForm_lb;
import com.example.stock.VO.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 17:01
 */
@RestController
@RequestMapping("/tradelb")
public class LargeTradeRecordController {

    @Autowired
    private LargeTradeRecordService largeTradeRecordService;

    @PostMapping("/kline")
    public ResponseVO getKLineData_lb(@ModelAttribute KLineRequestForm_lb kLineRequestForm_lb){
        return largeTradeRecordService.getKLineData_lb(kLineRequestForm_lb);
    }

    @PostMapping("/klineContrast")
    public ResponseVO getContrastKLineData(@ModelAttribute KLineRequestForm_lb kLineRequestForm_lb){
        return largeTradeRecordService.getContrastKLineData(kLineRequestForm_lb);
    }

}
