package com.xxxx.flyserver.service;

import com.xxxx.flyserver.pojo.GoodsType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 货物类别 服务类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface IGoodsTypeService extends IService<GoodsType> {

    /**
     * 获取货物类型
     * @return
     */
    List<GoodsType> getGoodsType();

}
