package com.xxxx.flyserver.service.impl;

import com.xxxx.flyserver.pojo.CarState;
import com.xxxx.flyserver.mapper.CarStateMapper;
import com.xxxx.flyserver.service.ICarStateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车辆状态 服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Service
public class CarStateServiceImpl extends ServiceImpl<CarStateMapper, CarState> implements ICarStateService {

}
