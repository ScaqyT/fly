package com.xxxx.flyserver.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxxx.flyserver.pojo.Goods;
import com.xxxx.flyserver.pojo.Operation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 车辆运营 Mapper 接口
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface OperationMapper extends BaseMapper<Operation> {

    /**
     * 获取托运单
     *
     * @return
     */
    List<Operation> getOperation();

    /**
     * 生成托运单
     *
     * @param operation
     * @return
     */
    void addOperation(Operation operation);

    /**
     * 删除车辆运营信息
     *
     * @param operation
     * @return
     */
//    void deleteOperation(Operation operation);

    List<Goods> getOperationWithGoods(@Param("oid") Integer oid);
}
