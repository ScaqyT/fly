package com.xxxx.flyserver.controller;


import com.xxxx.flyserver.pojo.Driver;
import com.xxxx.flyserver.pojo.DriverSearch;
import com.xxxx.flyserver.pojo.RespBean;
import com.xxxx.flyserver.pojo.RespPageBean;
import com.xxxx.flyserver.service.IDriverService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.dnd.DragSource;
import java.util.List;

/**
 * <p>
 * 司机信息 前端控制器
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@RestController
@RequestMapping("/car/driver/info")
public class DriverController {

    @Autowired
    private IDriverService driverService;


    @ApiOperation(value = "获取司机信息(分页)")
    @GetMapping("/")
    public RespPageBean getDriverByPage(DriverSearch driver){
        return driverService.getDriverByPage(driver);
    }

    @ApiOperation(value = "添加司机信息")
    @PostMapping("/")
    public RespBean addDriver(@RequestBody Driver driver){
        if(driverService.save(driver)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @ApiOperation(value = "更新司机信息")
    @PutMapping("/")
    public RespBean updateDriver(@RequestBody Driver driver){
        if(driverService.updateById(driver)){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "删除司机信息")
    @DeleteMapping("/{id}")
    public RespBean deleteDriver(@PathVariable("id") Integer id){
        if(driverService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

}
