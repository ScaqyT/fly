package com.xxxx.flyserver.service.impl;

import com.xxxx.flyserver.pojo.CarType;
import com.xxxx.flyserver.mapper.CarTypeMapper;
import com.xxxx.flyserver.service.ICarTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车辆类型 服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Service
public class CarTypeServiceImpl extends ServiceImpl<CarTypeMapper, CarType> implements ICarTypeService {

}
