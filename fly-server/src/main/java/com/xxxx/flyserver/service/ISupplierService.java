package com.xxxx.flyserver.service;

import com.xxxx.flyserver.pojo.Supplier;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 供应商信息 服务类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface ISupplierService extends IService<Supplier> {

    List<Supplier> getSupplier(Integer id);
}
