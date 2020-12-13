package com.example.stock.Controller;

import com.example.stock.Biz.StockInfoService;
import com.example.stock.Biz.TushareStockDataService;
import com.example.stock.Form.NewsTimeStampForm;
import com.example.stock.Form.TushareStockDataForm;
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
public class TushareStockDataController {
    @Autowired
    private TushareStockDataService tushareStockDataService;

    @PostMapping("/tushareStockData")
    public ResponseVO getTushareStockData(@ModelAttribute TushareStockDataForm tushareStockDataForm){
        return tushareStockDataService.getTushareStockData(tushareStockDataForm.getSchema(), tushareStockDataForm.getTs_code(),
                tushareStockDataForm.getFromTime(), tushareStockDataForm.getToTime());
    }

}
