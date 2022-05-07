package com.xxxx.flyserver.controller;


import com.xxxx.flyserver.pojo.CarType;
import com.xxxx.flyserver.pojo.RespBean;
import com.xxxx.flyserver.service.ICarTypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 车辆类型 前端控制器
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@RestController
@RequestMapping("/car/info/type")
public class CarTypeController {
    @Autowired
    private ICarTypeService carTypeService;

    @ApiOperation(value = "获取车辆类型")
    @GetMapping("/")
    public List<CarType> getCarType(){
        return carTypeService.list();
    }

    @ApiOperation(value = "添加车辆类型")
    @PostMapping("/")
    public RespBean addCarType(@RequestBody CarType carType){
        if(carTypeService.save(carType)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @ApiOperation(value = "更新车辆类型")
    @PutMapping("/")
    public RespBean updateCarType(@RequestBody CarType carType){
        if(carTypeService.updateById(carType)){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "删除车辆类型")
    @PostMapping("/{id}")
    public RespBean addCarType(@PathVariable("id") Integer id){
        if(carTypeService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
