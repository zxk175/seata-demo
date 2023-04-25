package com.zxk175.order.service.impl;

import com.zxk175.order.dao.OrderDao;
import com.zxk175.order.entity.Order;
import com.zxk175.order.feign.StockFeignClient;
import com.zxk175.order.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author zxk175
 * @since 2023-04-24 23:06
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final StockFeignClient stockFeignClient;
    private final OrderDao orderDao;


    @Override
    @GlobalTransactional
    public void placeOrder(String userId, String commodityCode, Integer count) {
        log.info("OrderService XID = {}", RootContext.getXID());
        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));
        Order order = new Order()
                .setUserId(userId)
                .setCommodityCode(commodityCode)
                .setCount(count)
                .setMoney(orderMoney);
        orderDao.insert(order);
        try {
            stockFeignClient.deduct(commodityCode, count);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
