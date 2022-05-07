package com.xxxx.flyserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.flyserver.mapper.WarehouseMapper;
import com.xxxx.flyserver.pojo.Warehouse;
import com.xxxx.flyserver.service.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 仓库信息 服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-03-13
 */
@Service
public class WarehouseServiceImpl extends ServiceImpl<WarehouseMapper, Warehouse> implements IWarehouseService {

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public List<Warehouse> getWarehouse(Integer id) {
        return warehouseMapper.getWarehouse(id);
    }
}
