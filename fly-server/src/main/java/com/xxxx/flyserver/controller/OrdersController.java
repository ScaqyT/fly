package com.xxxx.flyserver.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxxx.flyserver.pojo.Operation;
import com.xxxx.flyserver.pojo.OrderSearch;
import com.xxxx.flyserver.pojo.Orders;
import com.xxxx.flyserver.pojo.RespBean;
import com.xxxx.flyserver.service.IOrdersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 出货单信息 前端控制器
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@RestController
@RequestMapping("/order/o")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    @ApiOperation(value = "获取出货单")
    @GetMapping("/")
    public List<Orders> getAllOrders(OrderSearch orderSearch){
        return ordersService.getAllOrders(orderSearch);
    }

    @ApiOperation(value = "添加出货单")
    @PostMapping("/")
    public RespBean addOrder(@RequestBody Orders orders){
        return ordersService.addOrder(orders);
    }

    @ApiOperation(value = "更新出货单")
    @PutMapping("/")
    public RespBean updateOrder(@RequestParam("id") Integer id){
        return ordersService.updateOrder(id);
    }

    @ApiOperation(value = "删除出货单")
    @DeleteMapping("/{id}")
    public RespBean deleteOrder(@PathVariable("id") Integer id){
        Orders orders = (Orders)ordersService.list(new QueryWrapper<Orders>().eq("id", id));
        return ordersService.deleteOrder(orders,id);
    }

    @ApiOperation(value = "获取未分配送货单的托运单")
    @GetMapping("/operation")
    public List<Operation> getNoPoOperation(){
        return ordersService.getNoOrderOperation();
    }

}
