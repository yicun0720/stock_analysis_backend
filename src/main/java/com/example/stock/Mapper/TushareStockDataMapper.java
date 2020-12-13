package com.example.stock.Mapper;

import com.example.stock.DO.TushareStockData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ Description
 * @ Author CaoYang
 * @ Date 2020/12/13
 */

public interface TushareStockDataMapper {
    List<TushareStockData> getTushareStockData(@Param("schema") String schema, @Param("ts_code") String ts_code, @Param("fromTime") int fromTime, @Param("toTime") int toTime);

}
