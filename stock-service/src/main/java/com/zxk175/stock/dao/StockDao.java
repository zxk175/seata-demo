package com.zxk175.stock.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxk175.stock.entity.Stock;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zxk175
 * @since 2023-04-24 22:44
 */
@Mapper
public interface StockDao extends BaseMapper<Stock> {

}
