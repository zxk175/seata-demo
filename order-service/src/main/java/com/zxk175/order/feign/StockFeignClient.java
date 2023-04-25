package com.zxk175.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zxk175
 * @since 2023-04-24 23:11
 */
@FeignClient(name = "stock-service")
public interface StockFeignClient {

    @GetMapping("stock/deduct")
    Boolean deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count);

}
