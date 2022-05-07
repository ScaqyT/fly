package com.xxxx.flyserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxxx.flyserver.pojo.*;
import com.xxxx.flyserver.mapper.CarMapper;
import com.xxxx.flyserver.service.ICarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 * 车辆信息 服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements ICarService {

    @Autowired
    private CarMapper carMapper;


    @Override
    public RespPageBean getCarByPage(CarSearch carSearch) {
        //开启分页
        List<Car> carByPage = carMapper.getCarByPage(carSearch);
        long total = carByPage.size();
        RespPageBean respPageBean =new RespPageBean(total,carByPage);
        return respPageBean;
    }

    /**
     * 添加车辆
     * @param car
     * @return
     */
    @Override
    public RespBean addCar(Car car) {
        car.setState(1);
        int i = carMapper.insert(car);
        if(i>0){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    /**
     * 获取空闲车辆
     * @return
     */
    @Override
    public List<Car> getFreeCar() {
        return carMapper.selectList(new QueryWrapper<Car>().eq("state",1));
    }

}
