package com.example.stock.VO;

import com.example.stock.DO.TradeRecord;

import java.util.List;

public class TwoRecordList {
    private List<TradeRecord> tr_list_origin;
    private List<TradeRecord> tr_list_lb;

    public TwoRecordList(List<TradeRecord> tr_list_origin, List<TradeRecord> tr_list_lb){
        this.tr_list_origin = tr_list_origin;
        this.tr_list_lb = tr_list_lb;
    }

    public List<TradeRecord> getTr_list_origin(){
        return tr_list_origin;
    }

    public List<TradeRecord> getTr_list_lb(){
        return tr_list_lb;
    }
}
