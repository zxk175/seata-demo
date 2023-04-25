package com.zxk175.stock.service;

/**
 * @author zxk175
 * @since 2023-04-24 22:46
 */
public interface StockService {

    /**
     * 减库存
     */
    void deduct(String commodityCode, int count);

}
