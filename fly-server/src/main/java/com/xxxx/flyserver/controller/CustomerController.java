package com.xxxx.flyserver.controller;


import com.xxxx.flyserver.pojo.Customer;
import com.xxxx.flyserver.pojo.RespBean;
import com.xxxx.flyserver.service.ICustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 客户信息 前端控制器
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@RestController
@RequestMapping("/customer/info")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @ApiOperation(value = "获取客户信息")
    @GetMapping("/")
    public List<Customer> getCustomer(Integer id){
        return customerService.getCustomer(id);
    }

    @ApiOperation(value = "添加客户信息")
    @PostMapping("/")
    public RespBean addCustomer(@RequestBody Customer customer){
        if(customerService.save(customer)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @ApiOperation(value = "更新客户信息")
    @PutMapping("/")
    public RespBean updateCustomer(@RequestBody Customer customer){
        if(customerService.updateById(customer)){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "删除客户信息")
    @DeleteMapping("/{id}")
    public RespBean deleteCustomer(@PathVariable("id") Integer id){
        if(customerService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
