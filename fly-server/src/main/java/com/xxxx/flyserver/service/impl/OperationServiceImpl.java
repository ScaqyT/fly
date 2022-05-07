package com.xxxx.flyserver.service.impl;

import com.xxxx.flyserver.mapper.CustomerMapper;
import com.xxxx.flyserver.mapper.SupplierMapper;
import com.xxxx.flyserver.pojo.*;
import com.xxxx.flyserver.mapper.OperationMapper;
import com.xxxx.flyserver.service.IOperationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 车辆运营 服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Service
public class OperationServiceImpl extends ServiceImpl<OperationMapper, Operation> implements IOperationService {

    @Autowired
    private OperationMapper operationMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private SupplierMapper supplierMapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 获取托运单
     * @return
     */
    @Override
    public List<Operation> getOperation() {
        List<Operation> list = operationMapper.getOperation();

        return list;
    }

    /**
     * 生成托运单
     * @param operation
     * @return
     */
    @Override
    public RespBean addOperation(Operation operation) {
        operationMapper.addOperation(operation);
        Integer cid = operation.getCustomerId();
        Customer customer = customerMapper.getCustomer(cid).get(0);
        Integer sid = operation.getSupplierId();
        Supplier supplier = supplierMapper.getSupplier(sid).get(0);
        operation.setCustomer(customer);
        operation.setSupplier(supplier);
        if (operation.getResult() == 1){

            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    /**
     * 删除托运单
     * @param id
     * @return
     */
//    @Override
//    public RespBean deleteOperation(Integer id) {
//        Operation operation = operationMapper.selectById(id);
//        operationMapper.deleteOperation(operation);
//        if(operation.getResult() == 1){
//            return RespBean.success("删除成功");
//        }
//        return RespBean.error("删除失败");
//    }

    /**
     * 获取托运明细
     * @return
     * @param oid
     */
    @Override
    public List<Goods> getOperationWithGoods(Integer oid) {
        return operationMapper.getOperationWithGoods(oid);
    }

}
