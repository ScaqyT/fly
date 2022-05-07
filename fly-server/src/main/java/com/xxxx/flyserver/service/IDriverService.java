package com.xxxx.flyserver.service;

import com.xxxx.flyserver.pojo.Driver;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.flyserver.pojo.DriverSearch;
import com.xxxx.flyserver.pojo.RespPageBean;

import java.util.List;

/**
 * <p>
 * 司机信息 服务类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface IDriverService extends IService<Driver> {

    /**
     * 获取司机信息
     * @param driver
     * @return
     */
    RespPageBean getDriverByPage(DriverSearch driver);

    /**
     * 获取空闲司机
     * @return
     */
    List<Driver> getFreeDriver();
}
