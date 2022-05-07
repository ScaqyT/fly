package com.xxxx.flyserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.flyserver.pojo.InWarehouse;
import com.xxxx.flyserver.pojo.OutInSearch;

import java.util.List;

/**
 * <p>
 * 入库信息 Mapper 接口
 * </p>
 *
 * @author cxf
 * @since 2022-03-15
 */
public interface InWarehouseMapper extends BaseMapper<InWarehouse> {

    List<InWarehouse> getInWarehouse(OutInSearch outInSearch);
}
