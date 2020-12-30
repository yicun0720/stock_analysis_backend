package com.example.stock.Controller;

import com.example.stock.Biz.DailyCostService;
import com.example.stock.Form.DailyCostRequestForm;
import com.example.stock.VO.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/30 17:10
 */
@RestController
public class DailyCostControler {
    @Autowired
    private DailyCostService dailyCostService;

    @PostMapping("/dailyTradeCost")
    public ResponseVO getDailyTradeCost(@ModelAttribute DailyCostRequestForm dailyCostRequestForm){
        return dailyCostService.getDailyTradeCost
                (dailyCostRequestForm.getCode(), dailyCostRequestForm.getTradeDate());
    }
}
