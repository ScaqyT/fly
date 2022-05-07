package com.xxxx.flyserver.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxxx.flyserver.pojo.Car;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.flyserver.pojo.CarSearch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 车辆信息 Mapper 接口
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface CarMapper extends BaseMapper<Car> {

    List<Car> getCarByPage(CarSearch carSearch);
}
