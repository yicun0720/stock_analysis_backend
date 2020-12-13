package com.example.stock.VO;

import lombok.Data;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/13 16:16
 */
@Data
public class NewsVO {
    private int id;

    private String dateTime;
    private String content;
    private String title;
}
