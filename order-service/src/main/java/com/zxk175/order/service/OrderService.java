package com.zxk175.order.service;

/**
 * @author zxk175
 * @since 2023-04-24 23:06
 */
public interface OrderService {

    /**
     * 下单：创建订单、减库存，涉及到两个服务
     * <p>
     * Transactional 和 GlobalTransactional 冲突，导致undo_log无数据，但是全局事务控制正常生效
     */
    void placeOrder(String userId, String commodityCode, Integer count);

}
