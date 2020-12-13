package com.example.stock.Controller;

import com.example.stock.Biz.StockInfoService;
import com.example.stock.Form.NewsTimeStampForm;
import com.example.stock.VO.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 14:07
 */
@CrossOrigin
@RestController
public class StockInfoController {
    @Autowired
    private StockInfoService stockInfoService;

    @PostMapping("/stockInfo")
    public ResponseVO getStockInfoByCode(@RequestParam String code){
        return stockInfoService.getStockInfoByCode(code);
    }

    @PostMapping("/news")
    public ResponseVO getStockNews(@ModelAttribute NewsTimeStampForm newsTimeStampForm){
        return stockInfoService.getStockNews(newsTimeStampForm.getFromTime(), newsTimeStampForm.getToTime());
    }

}
