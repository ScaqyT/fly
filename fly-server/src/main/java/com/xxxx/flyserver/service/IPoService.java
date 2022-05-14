package com.xxxx.flyserver.service;

import com.xxxx.flyserver.pojo.Operation;
import com.xxxx.flyserver.pojo.OrderSearch;
import com.xxxx.flyserver.pojo.Po;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.flyserver.pojo.RespBean;

import java.util.List;

/**
 * <p>
 * 采购订单信息 服务类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface IPoService extends IService<Po> {

    List<Po> getAllPo(OrderSearch orderSearch);

    RespBean updatePo(Integer id);

    RespBean AddPo(Po po);

    RespBean deletePo(Po po,Integer id);

    List<Operation> getNoPoOperation();
}
