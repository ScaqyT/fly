package com.xxxx.flyserver.controller;


import com.xxxx.flyserver.pojo.*;
import com.xxxx.flyserver.service.IInWarehouseService;
import com.xxxx.flyserver.service.IOutWarehouseService;
import com.xxxx.flyserver.service.IPoService;
import com.xxxx.flyserver.util.RedisUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 入库信息 前端控制器
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@RestController
@RequestMapping("/warehouse/in")
public class InWarehouseController {

    @Autowired
    private IInWarehouseService inWarehouseService;
    @Autowired
    private IPoService poService;
    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation(value = "获取入库单")
    @GetMapping("/")
    public List<InWarehouse> getInWarehouse(OutInSearch outInSearch){
        return inWarehouseService.getInWarehouse(outInSearch);
    }

//    @ApiOperation(value = "添加入库单")
//    @PostMapping("/")
//    public RespBean addInWarehouse(@RequestBody Integer id){
//        if(inWarehouseService.save(inWarehouse)){
//            //更新采购订单状态
//            Integer orderId = inWarehouse.getOrderId();
//            Po po = poService.getById(orderId);
//            po.setState(6);
//            if(poService.updateById(po)){
//                return RespBean.success("入库成功，订单状态已更新");
//            }
//        }
//        return RespBean.error("添加失败");
//    }

    @ApiOperation(value = "更新入库单")
    @PutMapping("/")
    public RespBean updateInWarehouse(@RequestParam("id") Integer id){
        InWarehouse inWarehouse = inWarehouseService.getById(id);
        inWarehouse.setState(1);
        if(inWarehouseService.updateById(inWarehouse)){
            Integer orderId = inWarehouse.getOrderId();
            Po po = poService.getById(orderId);
            po.setState(6);
            if(poService.updateById(po)){
                redisUtil.del("inGoods");
                return RespBean.success("入库成功");
            }

        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "删除入库单")
    @DeleteMapping("/{id}")
    public RespBean deleteInWarehouse(@PathVariable("id") Integer id){
        if(inWarehouseService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @ApiOperation(value = "获取入库总货物")
    @GetMapping("/inGoods")
    public Integer getOutGoods(){
        return inWarehouseService.getOutGoods();
    }

}
