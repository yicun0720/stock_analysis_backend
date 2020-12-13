package com.example.stock.Biz.BizImpl;

import com.example.stock.Biz.TushareStockDataService;
import com.example.stock.DO.TushareStockData;
import com.example.stock.Mapper.TushareStockDataMapper;
import com.example.stock.VO.ResponseVO;
import com.example.stock.VO.TushareStockDataVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description
 * @ Author CaoYang
 * @ Date 2020/12/13
 */
@Service
public class TushareStockDataServiceImpl implements TushareStockDataService {

    private static final String NO_SUCH_STOCK_CODE_ERR = "股票代码不存在";
    private static final String NO_SUCH_SCHEMA_ERR = "数据表不存在";

    @Autowired
    private TushareStockDataMapper tushareStockDataMapper;

    @Override
    public ResponseVO getTushareStockData(String schema, String ts_code, int fromTime, int toTime){
        List<TushareStockData> tushareStockDataList = tushareStockDataMapper.getTushareStockData(schema, ts_code, fromTime, toTime);

        List<TushareStockDataVO> tushareStockDataVOList = new ArrayList<>();
        for(TushareStockData tushareStockData: tushareStockDataList){
            TushareStockDataVO tushareStockDataVO = new TushareStockDataVO();
            BeanUtils.copyProperties(tushareStockData, tushareStockDataVO);
            tushareStockDataVOList.add(tushareStockDataVO);
        }

        return ResponseVO.buildSuccess(tushareStockDataVOList);
    }
}
