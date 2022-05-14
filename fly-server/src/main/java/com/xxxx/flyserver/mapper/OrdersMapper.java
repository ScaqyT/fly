package com.xxxx.flyserver.mapper;

import com.xxxx.flyserver.pojo.Operation;
import com.xxxx.flyserver.pojo.OrderSearch;
import com.xxxx.flyserver.pojo.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 订单信息 Mapper 接口
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface OrdersMapper extends BaseMapper<Orders> {

    List<Orders> getAllOrders(OrderSearch orderSearch);
}
