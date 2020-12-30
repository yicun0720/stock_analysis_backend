package com.example.stock.Mapper;

import com.example.stock.DO.TradeVolumeStat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/30 16:46
 */
public interface DailyCostMapper {

    List<TradeVolumeStat> getDailyCostByCodeAndDate(@Param("code") String code,
                                                    @Param("tradeDate") String tradeDate);

}
