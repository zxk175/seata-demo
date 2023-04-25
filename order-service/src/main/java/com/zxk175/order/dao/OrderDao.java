package com.zxk175.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxk175.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zxk175
 * @since 2023-04-24 23:05
 */
@Mapper
public interface OrderDao extends BaseMapper<Order> {

}
