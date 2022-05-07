package com.xxxx.flyserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.flyserver.pojo.Warehouse;

import java.util.List;

/**
 * <p>
 * 仓库信息 服务类
 * </p>
 *
 * @author cxf
 * @since 2022-03-13
 */
public interface IWarehouseService extends IService<Warehouse> {

    List<Warehouse> getWarehouse(Integer id);
}
