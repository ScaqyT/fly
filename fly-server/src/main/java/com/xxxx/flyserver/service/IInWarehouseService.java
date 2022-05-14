package com.xxxx.flyserver.service;

import com.xxxx.flyserver.pojo.InWarehouse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.flyserver.pojo.OutInSearch;

import java.util.List;

/**
 * <p>
 * 入库信息 服务类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface IInWarehouseService extends IService<InWarehouse> {

    List<InWarehouse> getInWarehouse(OutInSearch outInSearch);

    Integer getOutGoods();
}
