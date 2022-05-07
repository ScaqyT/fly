package com.xxxx.flyserver.service.impl;

import com.xxxx.flyserver.mapper.GoodsMapper;
import com.xxxx.flyserver.mapper.OutWarehouseMapper;
import com.xxxx.flyserver.pojo.*;
import com.xxxx.flyserver.mapper.OrdersMapper;
import com.xxxx.flyserver.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static sun.misc.VM.getState;

/**
 * <p>
 * 订单信息 服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OutWarehouseMapper outWarehouseMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Orders> getAllOrders(OrderSearch orderSearch) {
        return ordersMapper.getAllOrders(orderSearch);
    }

    @Override
    public RespBean updateOrder(Integer id) {
        Orders orders = ordersMapper.selectById(id);
        Integer state = orders.getState();
        if(state==2){
            orders.setState(state+1);
            RespBean outWhRespBean = null;
            OutWarehouse outWarehouse = null;
            //订单状态是已发货，创建出库单
            //以orders数据生成outWarehouse对象
            outWarehouse = new OutWarehouse();
            outWarehouse.setCustomerId(Integer.parseInt(orders.getCustomerId()));
            outWarehouse.setDate(LocalDateTime.now());
            outWarehouse.setGoodsId(orders.getGoodsId());
            outWarehouse.setQuantity(orders.getQuality());
            outWarehouse.setOrderId(id);
            outWarehouse.setState(0);
            outWarehouse.setWarehouseId(goodsMapper.selectById(orders.getGoodsId()).getOriginId());

            if(ordersMapper.updateById(orders)>0){
                if(outWarehouseMapper.insert(outWarehouse)>0){
                    outWhRespBean = new RespBean(200,"出库单创建成功",null);
                }else{
                    return RespBean.error("出库单创建失败");
                }
                return RespBean.success("更新成功",outWhRespBean);
            }
        }
        return RespBean.error("更新失败");
    }

    /**
     * 删除出货单
     * @param orders
     * @param id
     * @return
     */
    @Override
    public RespBean deleteOrder(Orders orders, Integer id) {
        if(orders.getState()<5){
            return RespBean.error("出货单尚未完成，禁止删除!");
        }
        int i = ordersMapper.deleteById(id);
        if(i>0){
            return RespBean.success("出货单删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    /**
     * 添加出货单
     * @param orders
     * @return
     */
    @Override
    public RespBean addOrder(Orders orders) {
        orders.setState(1);
        int i = ordersMapper.insert(orders);
        if(i>0){
            return RespBean.success("订单生成成功！");
        }
        return RespBean.error("订单生成失败！");
    }
}
