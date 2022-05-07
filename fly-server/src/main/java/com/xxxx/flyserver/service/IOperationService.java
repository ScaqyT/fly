package com.xxxx.flyserver.service;

import com.xxxx.flyserver.pojo.Goods;
import com.xxxx.flyserver.pojo.Operation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.flyserver.pojo.RespBean;
import com.xxxx.flyserver.pojo.RespPageBean;

import java.util.List;

/**
 * <p>
 * 车辆运营 服务类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface IOperationService extends IService<Operation> {

    /**
     * 获取车辆运营信息
     * @return
     */
    List<Operation> getOperation();

    /**
     * 添加车辆运营信息
     * @param operation
     * @return
     */
    RespBean addOperation(Operation operation);

    /**
     * 删除车辆运营信息
     * @param id
     * @return
     */
//    RespBean deleteOperation(Integer id);

    /**
     * 获取托运明细
     * @return
     * @param oid
     */
    List<Goods> getOperationWithGoods(Integer oid);
}
