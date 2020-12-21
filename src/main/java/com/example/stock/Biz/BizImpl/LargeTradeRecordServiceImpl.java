package com.example.stock.Biz.BizImpl;

import com.example.stock.Biz.LargeTradeRecordService;
import com.example.stock.Biz.TradeRecordService;
import com.example.stock.Biz.TradeRecordServiceForBl;
import com.example.stock.DO.KLineRequest_lb;
import com.example.stock.DO.TradeRecord;
import com.example.stock.Form.KLine;
import com.example.stock.Form.KLineRequestForm;
import com.example.stock.Form.KLineRequestForm_lb;
import com.example.stock.Mapper.LargeTradeRecordMapper;
import com.example.stock.Utils.DateUtil;
import com.example.stock.Utils.UtilDO.DateTimeRange;
import com.example.stock.VO.ResponseVO;
import com.example.stock.VO.TradeRecordVO;
import com.example.stock.VO.TwoRecordList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 18:50
 */
@Service
public class LargeTradeRecordServiceImpl implements LargeTradeRecordService {
    @Autowired
    private LargeTradeRecordMapper largeTradeRecordMapper;

    @Autowired
    private TradeRecordServiceForBl tradeRecordServiceForBl; //这部分写的有点不规范了

    @Override
    public ResponseVO getKLineData_lb(KLineRequestForm_lb kLineRequestForm_lb){
        dateTimeToWorkday(kLineRequestForm_lb);

        List<TradeRecord> tradeRecordList = kLineDispatcher(kLineRequestForm_lb);
        if(tradeRecordList == null){
            return ResponseVO.buildFailure("未知K线类型");
        }

        List<TradeRecordVO> tradeRecordVOList = new ArrayList<>();
        for(TradeRecord tradeRecord: tradeRecordList){
            TradeRecordVO tradeRecordVO = new TradeRecordVO();
            BeanUtils.copyProperties(tradeRecord, tradeRecordVO);
            tradeRecordVOList.add(tradeRecordVO);
        }
        return ResponseVO.buildSuccess(tradeRecordVOList);
    }

    private void dateTimeToWorkday(KLineRequestForm_lb form_lb){
        //日k不处理
        if(form_lb.getKLine() == KLine.K_1D){
            return;
        }
        DateTimeRange dateTimeRange =
                DateUtil.parseDateToNearestWorkday(form_lb.getFromDate(), form_lb.getToDate());
        if(dateTimeRange != null) {
            form_lb.setFromDate(dateTimeRange.getFromDateTime());
            form_lb.setToDate(dateTimeRange.getToDateTime());
        }
    }

    private List<TradeRecord> kLineDispatcher(KLineRequestForm_lb kLineRequestForm_lb){
        KLineRequest_lb kLineRequest_lb = new KLineRequest_lb(kLineRequestForm_lb);
        List<TradeRecord> tradeRecordList;

        KLine kLineType = kLineRequestForm_lb.getKLine();
        switch (kLineType){
            case K_5MIN:
                tradeRecordList = largeTradeRecordMapper.getTradeRecord_5min(kLineRequest_lb);
                break;
            case K_15MIN:
                tradeRecordList = largeTradeRecordMapper.getTradeRecord_15min(kLineRequest_lb);
                break;
            case K_30MIN:
                tradeRecordList = largeTradeRecordMapper.getTradeRecord_30min(kLineRequest_lb);
                break;
            case K_60MIN:
                tradeRecordList = largeTradeRecordMapper.getTradeRecord_60min(kLineRequest_lb);
                break;
            case K_1D:
                tradeRecordList = largeTradeRecordMapper.getTradeRecord_1d(kLineRequest_lb);
                break;
            default:
                return null;
        }
        return tradeRecordList;
    }

    @Override
    public ResponseVO getContrastKLineData(KLineRequestForm_lb kLineRequestForm_lb){
        dateTimeToWorkday(kLineRequestForm_lb);

        List<TradeRecord> tr_list_lb = kLineDispatcher(kLineRequestForm_lb);
        List<TradeRecord> tr_list_origin =
                tradeRecordServiceForBl.getKLineDataForContrast(new KLineRequestForm(kLineRequestForm_lb));
        if(tr_list_lb == null || tr_list_origin == null
                || tr_list_lb.size() == 0 || tr_list_origin.size() == 0){
            return ResponseVO.buildFailure("K线数据缺失错误，读取失败");
        }
        String date_origin = DateUtil.fetchDateFromDateTime(tr_list_origin.get(0).getDate());
        String date_lb = DateUtil.fetchDateFromDateTime(tr_list_lb.get(0).getDate());
        if(!date_origin.equals(date_lb)){
            return ResponseVO.buildFailure("K线数据缺失错误，读取失败");
        }

        //washDate方法，包含一个时间粒度的参数gapMin，将tr_list_lb的date都向下取到最近的正确时间点，并补全中间缺少的时间
        washDate(tr_list_lb, 5);
        System.out.println(tr_list_lb.size());
        for(TradeRecord tradeRecord:tr_list_lb){
            System.out.println(tradeRecord.getDate());
        }
        TwoRecordList twoRecordList = new TwoRecordList(tr_list_origin,tr_list_lb);
        return ResponseVO.buildSuccess(twoRecordList);
    }

    private void washDate(List<TradeRecord> inRecord, int gapMin) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        long ts = 0;
        for(TradeRecord tradeRecord:inRecord){
            try {
                date = simpleDateFormat.parse(tradeRecord.getDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            ts = date.getTime();
            ts = (ts / (60000*gapMin)) * (60000*gapMin);
            date = new Date(ts);
            tradeRecord.setDate(simpleDateFormat.format(date));
        }
        for(int i = 0;i<inRecord.size()-1;i++){
            long ts1 = 0;
            long ts2 = 0;
            try {
                ts1 = simpleDateFormat.parse(inRecord.get(i).getDate()).getTime();
                ts2 = simpleDateFormat.parse(inRecord.get(i+1).getDate()).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if(ts2-ts1 != 60000*gapMin){
                int insertIndex = i+1;
                long tsAdd = ts1+60000*gapMin;
                while(true){
                    if(tsAdd<ts2 && isLegal(tsAdd)){
                        TradeRecord tradeRecord = new TradeRecord();
                        tradeRecord.setCode(inRecord.get(0).getCode());
                        tradeRecord.setDate(simpleDateFormat.format(new Date(tsAdd)));
                        tradeRecord.setHigh(-1.0);
                        tradeRecord.setLow(-1.0);
                        tradeRecord.setOpen(-1.0);
                        tradeRecord.setClose(-1.0);
                        inRecord.add(insertIndex,tradeRecord);
                    }else{
                        i = insertIndex+1;
                        break;
                    }
                    insertIndex++;
                    tsAdd+=60000*gapMin;
                }
            }
        }
        if(inRecord.size()>0){
            try {
                ts = simpleDateFormat.parse(inRecord.get(inRecord.size()-1).getDate()).getTime()+60000*gapMin;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            while(isLegal(ts)){
                TradeRecord tradeRecord = new TradeRecord();
                tradeRecord.setCode(inRecord.get(0).getCode());
                tradeRecord.setDate(simpleDateFormat.format(new Date(ts)));
                tradeRecord.setHigh(-1.0);
                tradeRecord.setLow(-1.0);
                tradeRecord.setOpen(-1.0);
                tradeRecord.setClose(-1.0);
                inRecord.add(tradeRecord);
                ts+=60000*gapMin;
            }
        }
    }

    private boolean isLegal(long time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time_str = simpleDateFormat.format(new Date(time)).substring(11);
        return (time_str.compareTo("09:30:00")>=0&&time_str.compareTo("11:30:00")<=0)
                ||(time_str.compareTo("13:00:00")>=0&&time_str.compareTo("15:00:00")<=0);

    }


}
