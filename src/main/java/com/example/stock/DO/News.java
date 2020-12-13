package com.example.stock.DO;

import lombok.Data;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 16:11
 */
@Data
public class News {

    private int id;

    private String dateTime;
    private String content;
    private String title;
}
