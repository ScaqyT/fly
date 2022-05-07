package com.xxxx.flyserver.mapper;

import com.xxxx.flyserver.pojo.Supplier;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 供应商信息 Mapper 接口
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface SupplierMapper extends BaseMapper<Supplier> {

    List<Supplier> getSupplier(Integer id);
}
