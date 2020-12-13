package com.example.stock.Mapper;

import com.example.stock.DO.Stock;
import org.apache.ibatis.annotations.Param;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 14:41
 */
public interface StockInfoMapper {

    Stock getStockInfoByCode(@Param("code") String code);

}
