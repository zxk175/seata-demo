package com.zxk175.stock.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zxk175
 * @since 2023-04-24 22:45
 */
@Data
@Accessors(chain = true)
@TableName("stock_tbl")
public class Stock {

    private Long id;

    private String commodityCode;

    private Long count;

}
