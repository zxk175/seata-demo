package com.zxk175.stock.controller;

import com.zxk175.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxk175
 * @since 2023-04-24 22:48
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("stock")
public class StockController {

    private final StockService stockService;

    /**
     * 减库存
     *
     * @param commodityCode 商品代码
     * @param count         数量
     * @return boolean
     */
    @RequestMapping(path = "/deduct")
    public Boolean deduct(String commodityCode, Integer count) {
        stockService.deduct(commodityCode, count);
        return true;
    }

}
