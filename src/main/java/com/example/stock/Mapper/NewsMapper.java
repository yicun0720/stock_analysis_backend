package com.example.stock.Mapper;

import com.example.stock.DO.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 16:13
 */
public interface NewsMapper {

    List<News> getStockNews(@Param("fromTime") String fromTime, @Param("toTime") String toTime);

}
