package com.xxxx.flyserver.service.impl;

import com.xxxx.flyserver.pojo.OutInSearch;
import com.xxxx.flyserver.pojo.OutWarehouse;
import com.xxxx.flyserver.mapper.OutWarehouseMapper;
import com.xxxx.flyserver.pojo.RespPageBean;
import com.xxxx.flyserver.service.IOutWarehouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 出库信息 服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Service
public class OutWarehouseServiceImpl extends ServiceImpl<OutWarehouseMapper, OutWarehouse> implements IOutWarehouseService {

    @Autowired
    private OutWarehouseMapper outWarehouseMapper;

    @Override
    public List<OutWarehouse> getOutWarehouse(OutInSearch outInSearch) {
        List<OutWarehouse> outWarehouse = outWarehouseMapper.getOutWarehouse(outInSearch);
        return outWarehouse;
    }
}
