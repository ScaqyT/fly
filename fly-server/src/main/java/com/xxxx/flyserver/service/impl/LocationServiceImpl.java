package com.xxxx.flyserver.service.impl;

import com.xxxx.flyserver.pojo.Location;
import com.xxxx.flyserver.mapper.LocationMapper;
import com.xxxx.flyserver.service.ILocationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 区位 服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Service
public class LocationServiceImpl extends ServiceImpl<LocationMapper, Location> implements ILocationService {

}
