package com.xxxx.flyserver.controller;


import com.xxxx.flyserver.pojo.*;
import com.xxxx.flyserver.service.IOrdersService;
import com.xxxx.flyserver.service.IOutWarehouseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 出库信息 前端控制器
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@RestController
@RequestMapping("/warehouse/out")
public class OutWarehouseController {

    @Autowired
    private IOutWarehouseService outWarehouseService;
    @Autowired
    private IOrdersService ordersService;

    @ApiOperation(value = "获取出库单")
    @GetMapping("/")
    public List<OutWarehouse> getOutWarehouse(OutInSearch outInSearch){
        return outWarehouseService.getOutWarehouse(outInSearch);
    }

    @ApiOperation(value = "添加出库单")
    @PostMapping("/")
    public RespBean addOutWarehouse(@RequestBody OutWarehouse outWarehouse){
        if(outWarehouseService.save(outWarehouse)){
            //更新订单状态
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @ApiOperation(value = "更新出库单")
    @PutMapping("/")
    public RespBean updateOutWarehouse(@RequestParam("id") Integer id){
        OutWarehouse outWarehouse = outWarehouseService.getById(id);
        outWarehouse.setState(1);
        if(outWarehouseService.updateById(outWarehouse)){
            Orders orders = ordersService.getById(outWarehouse.getOrderId());
            orders.setState(4);
            if(ordersService.updateById(orders)){
                return RespBean.success("出库成功");
            }
        }

        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "删除出库单")
    @DeleteMapping("/{id}")
    public RespBean deleteOutWarehouse(@PathVariable("id") Integer id){
        if(outWarehouseService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

}
