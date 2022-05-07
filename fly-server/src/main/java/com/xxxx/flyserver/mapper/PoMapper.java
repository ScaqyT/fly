package com.xxxx.flyserver.mapper;

import com.xxxx.flyserver.pojo.OrderSearch;
import com.xxxx.flyserver.pojo.Po;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 采购订单信息 Mapper 接口
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface PoMapper extends BaseMapper<Po> {

    List<Po> getAllPo(OrderSearch orderSearch);
}
