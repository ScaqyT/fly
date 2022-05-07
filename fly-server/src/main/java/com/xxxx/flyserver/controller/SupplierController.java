package com.xxxx.flyserver.controller;


import com.xxxx.flyserver.pojo.Customer;
import com.xxxx.flyserver.pojo.RespBean;
import com.xxxx.flyserver.pojo.Supplier;
import com.xxxx.flyserver.service.ISupplierService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 供应商信息 前端控制器
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@RestController
@RequestMapping("/supplier/info")
public class SupplierController {

    @Autowired
    private ISupplierService supplierService;


    @ApiOperation(value = "获取供应商信息")
    @GetMapping("/")
    public List<Supplier> getSupplier(Integer id){
        return supplierService.getSupplier(id);
    }

    @ApiOperation(value = "添加供应商信息")
    @PostMapping("/")
    public RespBean addSupplier(@RequestBody Supplier supplier){
        if(supplierService.save(supplier)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @ApiOperation(value = "更新供应商信息")
    @PutMapping("/")
    public RespBean updateSupplier(@RequestBody Supplier supplier){
        if(supplierService.updateById(supplier)){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "删除供应商信息")
    @DeleteMapping("/{id}")
    public RespBean deleteSupplier(@PathVariable("id") Integer id){
        if(supplierService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
