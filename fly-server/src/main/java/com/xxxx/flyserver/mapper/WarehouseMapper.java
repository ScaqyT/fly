package com.xxxx.flyserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.flyserver.pojo.Warehouse;

import java.util.List;

/**
 * <p>
 * 仓库信息 Mapper 接口
 * </p>
 *
 * @author cxf
 * @since 2022-03-13
 */
public interface WarehouseMapper extends BaseMapper<Warehouse> {

    List<Warehouse> getWarehouse(Integer id);
}
