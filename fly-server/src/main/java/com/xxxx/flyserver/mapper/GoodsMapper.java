package com.xxxx.flyserver.mapper;

import com.xxxx.flyserver.pojo.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.flyserver.pojo.GoodsSearch;

import java.util.List;

/**
 * <p>
 * 货物信息 Mapper 接口
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    /**
     * 获取货物信息
     * @param goodsSearch
     * @return
     */
    List<Goods> getAllGoods(GoodsSearch goodsSearch);
}
