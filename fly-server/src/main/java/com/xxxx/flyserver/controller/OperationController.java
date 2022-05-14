package com.xxxx.flyserver.controller;


import com.xxxx.flyserver.pojo.*;
import com.xxxx.flyserver.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆运营 前端控制器
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@RestController
@RequestMapping("/car/operation")
public class OperationController {

    @Autowired
    private IOperationService operationService;

    @Autowired
    private PoController poController;

    @Autowired
    private OrdersController ordersController;

    @Autowired
    private IChargemodeService chargemodeService;

    @Autowired
    private IAddressService addressService;



    @ApiOperation(value = "获取托运单")
    @GetMapping("/")
    public List<Operation> getOperation(){
        return operationService.getOperation();
    }

    @ApiOperation(value = "获取托运明细")
    @GetMapping("/goods")
    public List<Goods> getOperationWithGoods(Integer oid){
        return operationService.getOperationWithGoods(oid);
    }

    @ApiOperation(value = "添加托运单")
    @PostMapping("/")
    public RespBean addOperation(@RequestBody HashMap<String,Object> map){
        return operationService.addOperation(map);
    }

    @ApiOperation(value = "获取提货单")
    @GetMapping("/po")
    public List<Po> getPo(Integer oid){
        OrderSearch orderSearch = new OrderSearch();
        orderSearch.setOid(oid);
        return poController.getAllPo(orderSearch);
    }

    @ApiOperation(value = "获取出货单")
    @GetMapping("/o")
    public List<Orders> getOrders(Integer oid){
        OrderSearch orderSearch = new OrderSearch();
        orderSearch.setOid(oid);
        return ordersController.getAllOrders(orderSearch);
    }

    @ApiOperation(value = "获取计费方式")
    @GetMapping("/chargemode")
    public List<Chargemode> getChargemode(){
        return chargemodeService.list();
    }

    @ApiOperation(value = "获取地区")
    @GetMapping("/address")
    public List<Address> getAddress(){
        return addressService.getAddress();
    }

}
