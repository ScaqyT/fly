package com.xxxx.flyserver.service.impl;

import com.xxxx.flyserver.pojo.Supplier;
import com.xxxx.flyserver.mapper.SupplierMapper;
import com.xxxx.flyserver.service.ISupplierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 供应商信息 服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements ISupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public List<Supplier> getSupplier(Integer id) {

        return supplierMapper.getSupplier(id);
    }
}
