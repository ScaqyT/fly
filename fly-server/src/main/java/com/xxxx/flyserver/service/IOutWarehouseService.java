package com.xxxx.flyserver.service;

import com.xxxx.flyserver.pojo.OutInSearch;
import com.xxxx.flyserver.pojo.OutWarehouse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.flyserver.pojo.RespPageBean;

import java.util.List;

/**
 * <p>
 * 出库信息 服务类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface IOutWarehouseService extends IService<OutWarehouse> {

    List<OutWarehouse> getOutWarehouse(OutInSearch outInSearch);

    Integer getOutGoods();
}
