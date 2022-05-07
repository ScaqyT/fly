package com.xxxx.flyserver.service;

import com.xxxx.flyserver.pojo.*;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 车辆信息 服务类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface ICarService extends IService<Car> {

    /**
     * 获取车辆信息
     * @param carSearch
     * @return
     */
    RespPageBean getCarByPage(CarSearch carSearch);

    /**
     * 添加车辆
     * @param car
     * @return
     */
    RespBean addCar(Car car);

    /**
     * 获取空闲车辆
     * @return
     */
    List<Car> getFreeCar();


}
