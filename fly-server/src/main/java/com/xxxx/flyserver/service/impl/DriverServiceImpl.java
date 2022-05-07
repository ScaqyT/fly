package com.xxxx.flyserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxxx.flyserver.pojo.Driver;
import com.xxxx.flyserver.mapper.DriverMapper;
import com.xxxx.flyserver.pojo.DriverSearch;
import com.xxxx.flyserver.pojo.RespPageBean;
import com.xxxx.flyserver.service.IDriverService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 司机信息 服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Service
public class DriverServiceImpl extends ServiceImpl<DriverMapper, Driver> implements IDriverService {

    @Autowired
    private DriverMapper driverMapper;

    @Override
    public RespPageBean getDriverByPage(DriverSearch driver) {
        //开启分页
        List<Driver> iPage = driverMapper.getDriverByPage(driver);
        long total = iPage.size();
        RespPageBean respPageBean = new RespPageBean(total,iPage);
        return respPageBean;
    }

    @Override
    public List<Driver> getFreeDriver() {
        return driverMapper.selectList(new QueryWrapper<Driver>().eq("state","空闲"));
    }
}
