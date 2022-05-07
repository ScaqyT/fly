package com.xxxx.flyserver.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxxx.flyserver.pojo.Operation;
import com.xxxx.flyserver.pojo.OrderSearch;
import com.xxxx.flyserver.pojo.Po;
import com.xxxx.flyserver.pojo.RespBean;
import com.xxxx.flyserver.service.IOperationService;
import com.xxxx.flyserver.service.IPoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 提货单信息 前端控制器
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@RestController
@RequestMapping("/order/po")
public class PoController {

    @Autowired
    private IPoService poService;
    @Autowired
    private IOperationService operationService;

    @ApiOperation(value = "获取提货单")
    @GetMapping("/")
    public List<Po> getAllPo(OrderSearch orderSearch){
        return poService.getAllPo(orderSearch);
    }

    @ApiOperation(value = "添加提货单")
    @PostMapping("/")
    public RespBean AddPo(@RequestBody Po po){
        return poService.AddPo(po);
    }

    @ApiOperation(value = "更新提货单")
    @PutMapping("/")
    public RespBean updatePo(@RequestParam("id") Integer id){
        return poService.updatePo(id);
    }

    @ApiOperation(value = "删除提货单")
    @DeleteMapping("/{id}")
    public RespBean deletePo(@PathVariable("id") Integer id){
        Po po = (Po) poService.list(new QueryWrapper<Po>().eq("id", id));
        return poService.deletePo(po,id);
    }

    @ApiOperation(value = "获取未分配提货单的托运单")
    @GetMapping("/operation")
    public List<Operation> getNoPoOperation(){
        return operationService.list(new QueryWrapper<Operation>().eq("poId",null));
    }

}
