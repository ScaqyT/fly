package com.xxxx.flyserver.service;

import com.xxxx.flyserver.pojo.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.flyserver.pojo.GoodsSearch;
import com.xxxx.flyserver.pojo.RespBean;

import java.util.List;

/**
 * <p>
 * 货物信息 服务类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface IGoodsService extends IService<Goods> {

    /**
     * 获取货物信息
     * @param goodsSearch
     * @return
     */
    List<Goods> getAllGoods(GoodsSearch goodsSearch);

    RespBean addGoods(Goods goods);

    RespBean updateGoods(Goods goods);

    RespBean deleteGoods(Integer id);
}
