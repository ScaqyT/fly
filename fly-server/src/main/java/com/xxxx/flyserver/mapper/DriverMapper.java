package com.xxxx.flyserver.mapper;

import com.xxxx.flyserver.pojo.Driver;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.flyserver.pojo.DriverSearch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 司机信息 Mapper 接口
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface DriverMapper extends BaseMapper<Driver> {

    List<Driver> getDriverByPage(DriverSearch driver);
}
