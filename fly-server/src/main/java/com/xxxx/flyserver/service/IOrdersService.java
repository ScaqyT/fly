package com.xxxx.flyserver.service;

import com.xxxx.flyserver.pojo.Operation;
import com.xxxx.flyserver.pojo.OrderSearch;
import com.xxxx.flyserver.pojo.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.flyserver.pojo.RespBean;

import java.util.List;

/**
 * <p>
 * 订单信息 服务类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface IOrdersService extends IService<Orders> {

    List<Orders> getAllOrders(OrderSearch orderSearch);

    RespBean updateOrder(Integer id);

    RespBean deleteOrder(Orders orders, Integer id);

    RespBean addOrder(Orders orders);

    List<Operation> getNoOrderOperation();
}
