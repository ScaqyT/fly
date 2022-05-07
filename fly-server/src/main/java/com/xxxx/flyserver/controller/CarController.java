package com.xxxx.flyserver.controller;


import com.xxxx.flyserver.pojo.*;
import com.xxxx.flyserver.service.ICarService;
import com.xxxx.flyserver.service.ICarStateService;
import com.xxxx.flyserver.service.ICarTypeService;
import com.xxxx.flyserver.service.ILocationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 车辆信息 前端控制器
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@RestController
@RequestMapping("/car/info")
public class CarController {

    @Autowired
    private ICarService carService;
    @Autowired
    private ICarStateService carStateService;
    @Autowired
    private ICarTypeService carTypeService;
    @Autowired
    private ILocationService locationService;

    @ApiOperation(value = "获取车辆信息(分页)")
    @GetMapping("/")
    public RespPageBean getCarByPage(CarSearch carSearch){
        return carService.getCarByPage(carSearch);
    }

    @ApiOperation(value = "添加车辆信息")
    @PostMapping("/")
    public RespBean addCar(@RequestBody Car car){
        return carService.addCar(car);
    }

    @ApiOperation(value = "更新车辆信息")
    @PutMapping("/")
    public RespBean updateCar(@RequestBody Car car){
        if(carService.updateById(car)){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "删除车辆信息")
    @DeleteMapping("/{id}")
    public RespBean deleteCar(@PathVariable("id") Integer id){
        if(carService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.success("删除失败");
    }

    @ApiOperation(value = "获取车辆状态")
    @GetMapping("/state")
    public List<CarState> getCarState(){
        return carStateService.list();
    }

    @ApiOperation(value = "获取车辆类型")
    @GetMapping("/type")
    public List<CarType> getCarType(){
        return carTypeService.list();
    }

    @ApiOperation(value = "获取区位")
    @GetMapping("/location")
    public List<Location> getLocation(){
        return locationService.list();
    }

}

