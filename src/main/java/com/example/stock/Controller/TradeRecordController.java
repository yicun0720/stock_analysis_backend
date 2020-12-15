package com.example.stock.Controller;

import com.example.stock.Biz.TradeRecordService;
import com.example.stock.Form.KLineRequestForm;
import com.example.stock.VO.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ Description
 * @ Author CaoYang
 * @ Date 2020/12/13
 */
@CrossOrigin
@RestController
@RequestMapping("/trade")
public class TradeRecordController {
    @Autowired
    private TradeRecordService tradeRecordService;

    @PostMapping("/kline")
    public ResponseVO getKLineData(@ModelAttribute KLineRequestForm kLineRequestForm){
        return tradeRecordService.getKLineData(kLineRequestForm);
    }

    @PostMapping("/allStockDaily")
    public ResponseVO getAllStockDaily(@RequestParam String date){
        return tradeRecordService.getAllStockDaily(date);
    }

}
