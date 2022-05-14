package com.xxxx.flyserver.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxxx.flyserver.pojo.Employee;
import com.xxxx.flyserver.pojo.Location;
import com.xxxx.flyserver.pojo.RespBean;
import com.xxxx.flyserver.pojo.Warehouse;

import com.xxxx.flyserver.service.IEmployeeService;
import com.xxxx.flyserver.service.ILocationService;
import com.xxxx.flyserver.service.IWarehouseService;
import com.xxxx.flyserver.util.RedisUtil;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 仓库信息 前端控制器
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@RestController
@RequestMapping("/warehouse/w/info")
public class WarehouseController {

    @Autowired
    private IWarehouseService warehouseService;
    @Autowired
    private ILocationService locationService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation(value = "获取仓库信息")
    @GetMapping("/")
    public List<Warehouse> getWarehouse(Integer id){
        return warehouseService.getWarehouse(id);
    }

    @ApiOperation(value = "添加仓库信息")
    @PostMapping("/")
    public RespBean addWarehouse(@RequestBody Warehouse warehouse){
        if(warehouseService.save(warehouse)){
            redisUtil.del("warehouse");
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @ApiOperation(value = "更新仓库信息")
    @PutMapping("/")
    public RespBean updateWarehouse(@RequestBody Warehouse warehouse){
        if(warehouseService.updateById(warehouse)){
            redisUtil.del("warehouse");
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "删除仓库信息")
    @DeleteMapping("/{id}")
    public RespBean deleteWarehouse(@PathVariable("id") Integer id){
        if(warehouseService.removeById(id)){
            redisUtil.del("warehouse");
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @ApiOperation(value = "获取区位列表")
    @GetMapping("/location")
    public List<Location> getLocation(){
        return locationService.list();
    }

    @ApiOperation(value = "获取管理员列表")
    @GetMapping("/employee")
    public List<Employee> getEmployee(){
        return employeeService.list(new QueryWrapper<Employee>().eq("type",1));
    }

}
