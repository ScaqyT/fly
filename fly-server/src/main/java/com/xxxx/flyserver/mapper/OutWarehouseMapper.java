package com.xxxx.flyserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.flyserver.pojo.OutInSearch;
import com.xxxx.flyserver.pojo.OutWarehouse;

import java.util.List;

/**
 * <p>
 * 出库信息 Mapper 接口
 * </p>
 *
 * @author cxf
 * @since 2022-03-15
 */
public interface OutWarehouseMapper extends BaseMapper<OutWarehouse> {

    List<OutWarehouse> getOutWarehouse(OutInSearch outInSearch);

    List<OutWarehouse> getOutGoods();
}
