package com.xxxx.flyserver.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxxx.flyserver.mapper.*;
import com.xxxx.flyserver.pojo.*;
import com.xxxx.flyserver.service.IOperationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.flyserver.util.RedisUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private GoodsMapper goodsMapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RedisUtil redisUtil;

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
     * @param map
     * @return
     */
    @Override
    public RespBean addOperation(HashMap<String,Object> map) {
        Object ope = map.get("operation");
        //将LinkedHashMap转换成Operation实体类
        Operation operation = JSON.parseObject(JSON.toJSONString(ope), new TypeReference<Operation>() {
        });
        Object gl = map.get("goodsList");
        List<Goods> goodsList = JSON.parseObject(JSON.toJSONString(gl), new TypeReference<List<Goods>>(){});
        //添加客户和供应商操作
        if(operation.getSupplierId() != null){
            Integer sid = operation.getSupplierId();
            Supplier supplier = supplierMapper.getSupplier(sid).get(0);
            operation.setSupplier(supplier);
        }else{
            Supplier supplier = operation.getSupplier();
            int i = supplierMapper.insert(supplier);
            if(i>0){
                Integer id = supplierMapper.selectList(new QueryWrapper<Supplier>().orderByDesc("id").last("limit 1")).get(0).getId();
                operation.setSupplierId(id);
            }
        }

        if(operation.getCustomerId() != null){
            Integer cid = operation.getCustomerId();
            Customer customer = customerMapper.getCustomer(cid).get(0);
            operation.setCustomer(customer);
        }else{
            Customer customer = operation.getCustomer();
            int i = customerMapper.insert(customer);
            if(i>0){
                Integer id = customerMapper.selectList(new QueryWrapper<Customer>().orderByDesc("id").last("limit 1")).get(0).getId();
                operation.setCustomerId(id);
            }
        }

        operationMapper.addOperation(operation);
        if (operation.getResult() == 1){
            operation = operationMapper.selectList(new QueryWrapper<Operation>().orderByDesc("id").last("limit 1")).get(0);
            Integer oid = operation.getId();
            for (Goods goods : goodsList){
                goods.setOid(oid);
                goodsMapper.insert(goods);
            }
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
