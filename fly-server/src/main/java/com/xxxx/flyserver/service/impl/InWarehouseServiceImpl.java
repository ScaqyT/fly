package com.xxxx.flyserver.service.impl;

import com.xxxx.flyserver.pojo.InWarehouse;
import com.xxxx.flyserver.mapper.InWarehouseMapper;
import com.xxxx.flyserver.pojo.OutInSearch;
import com.xxxx.flyserver.service.IInWarehouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 入库信息 服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Service
public class InWarehouseServiceImpl extends ServiceImpl<InWarehouseMapper, InWarehouse> implements IInWarehouseService {

    @Autowired
    private InWarehouseMapper inWarehouseMapper;

    @Override
    public List<InWarehouse> getInWarehouse(OutInSearch outInSearch) {

        return inWarehouseMapper.getInWarehouse(outInSearch);
    }
}
