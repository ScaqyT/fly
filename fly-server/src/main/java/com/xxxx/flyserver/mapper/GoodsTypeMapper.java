package com.xxxx.flyserver.mapper;

import com.xxxx.flyserver.pojo.GoodsType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 货物类别 Mapper 接口
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface GoodsTypeMapper extends BaseMapper<GoodsType> {

    /**
     * 获取货物类型
     * @return
     */
    List<GoodsType> getGoodsType();
}
