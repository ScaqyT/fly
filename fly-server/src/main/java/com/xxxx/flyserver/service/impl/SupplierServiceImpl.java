package com.xxxx.flyserver.service.impl;

import com.xxxx.flyserver.pojo.Supplier;
import com.xxxx.flyserver.mapper.SupplierMapper;
import com.xxxx.flyserver.service.ISupplierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.flyserver.util.RedisUtil;
import io.jsonwebtoken.lang.Collections;
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
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<Supplier> getSupplier(Integer id) {
//        List<Supplier> supplier = (List<Supplier>) redisUtil.get("supplier");
//        if(Collections.isEmpty(supplier)){
           List<Supplier> supplier = supplierMapper.getSupplier(id);
//            redisUtil.set("supplier",supplier);
//        }
        return supplier;
    }
}
