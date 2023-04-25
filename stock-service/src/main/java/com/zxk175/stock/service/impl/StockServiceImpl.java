package com.zxk175.stock.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zxk175.stock.dao.StockDao;
import com.zxk175.stock.entity.Stock;
import com.zxk175.stock.service.StockService;
import io.seata.core.context.RootContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zxk175
 * @since 2023-04-24 22:46
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockDao stockDao;

    /**
     * 减库存
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deduct(String commodityCode, int count) {
        log.info("StockService XID = {}", RootContext.getXID());

        QueryWrapper<Stock> wrapper = new QueryWrapper<>();
        wrapper.setEntity(new Stock().setCommodityCode(commodityCode));
        Stock stock = stockDao.selectOne(wrapper);
        stock.setCount(stock.getCount() - count);

        stockDao.updateById(stock);
        if ("product-2".equals(commodityCode)) {
            throw new RuntimeException("异常:模拟业务异常:stock branch exception");
        }
    }

}
