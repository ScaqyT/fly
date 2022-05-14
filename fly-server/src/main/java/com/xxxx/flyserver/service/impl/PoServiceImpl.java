package com.xxxx.flyserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxxx.flyserver.mapper.*;
import com.xxxx.flyserver.pojo.*;
import com.xxxx.flyserver.service.IPoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.flyserver.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 采购订单信息 服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Service
public class PoServiceImpl extends ServiceImpl<PoMapper, Po> implements IPoService {

    @Autowired
    private PoMapper poMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private InWarehouseMapper inWarehouseMapper;
    @Autowired
    private OperationMapper operationMapper;
    @Autowired
    private DriverMapper driverMapper;
    @Autowired
    private CarMapper carMapper;

    @Override
    public List<Po> getAllPo(OrderSearch orderSearch) {
        return poMapper.getAllPo(orderSearch);
    }

    @Override
    public RespBean updatePo(Integer id) {
        Po po = poMapper.selectById(id);
        Integer state = po.getState();
        if(state==1){
            po.setState(4);
            int i = poMapper.updateById(po);
            if(i>0){
                return RespBean.success("更新成功");
            }
        }
        if(state==4){
            po.setState(5);
            RespBean respBean = null;
            Integer oid = po.getOid();
            List<Goods> opgoods = goodsMapper.selectList(new QueryWrapper<Goods>().eq("oid", oid));
            InWarehouse inWarehouse = new InWarehouse();
            inWarehouse.setName(po.getName());
            inWarehouse.setQuantity(po.getQuality());
            inWarehouse.setSupplierId(po.getSupplierId());
            inWarehouse.setDate(LocalDateTime.now());
            inWarehouse.setOrderId(id);
            inWarehouse.setState(0);
//            int num = 0;
//            for(Goods good : opgoods){
//                Integer gid = good.getId();
//                inWarehouse.setDate(LocalDateTime.now());
//                inWarehouse.setGoodsId(gid);
//                int i = inWarehouseMapper.insert(inWarehouse);
//                if(i>0) {num++;}
//            }
//            inWarehouse.setWarehouseId(po.getWarehouseId());
            int i = inWarehouseMapper.insert(inWarehouse);
            if(poMapper.updateById(po)>0){
                if(i >= 0){
                    {
                        Integer did = po.getDid();
                        Integer carId = po.getCarId();
                        //更新司机
                        Driver driver = driverMapper.selectById(did);
                        driver.setState("空闲");
                        driverMapper.updateById(driver);
                        //更新汽车
                        Car car = carMapper.selectById(carId);
                        car.setState(1);
                        carMapper.updateById(car);

                    }
                    if(i>0){
                        respBean = new RespBean(200,"入库单创建成功",null);
                    }else{
                        respBean = new RespBean(403,"入库单创建失败",null);
                    }
                    return RespBean.success("更新成功",respBean);
                }
            }
        }
        return RespBean.error("更新失败");
    }

    /**
     * 添加提货单
     * @param po
     * @return
     */
    @Override
    public RespBean AddPo(Po po) {
        Integer oid = po.getOid();
        Operation operation = operationMapper.selectList(new QueryWrapper<Operation>().eq("id", oid)).get(0);
        List<Goods> gList = goodsMapper.selectList(new QueryWrapper<Goods>().eq("oid", oid));
        String number = UUIDUtils.getUUID16();
        int quality = 0;
        for (Goods good: gList){
            quality += good.getQuantity();
        }
        po.setQuality(quality);
        po.setState(1);
        po.setCreatedate(LocalDateTime.now());
        po.setChargeMode(operation.getChargeMode());
        po.setMoney(operation.getQMoney());
        po.setNumber(number);
        po.setSupplierId(operation.getSupplierId());
        int i = poMapper.insert(po);
        if(i>0){
            {
                Integer did = po.getDid();
                Integer carId = po.getCarId();
                //更新司机
                Driver driver = driverMapper.selectById(did);
                driver.setState("忙碌");
                driverMapper.updateById(driver);
                //更新汽车
                Car car = carMapper.selectById(carId);
                car.setState(4);
                carMapper.updateById(car);
            }
            Po po2 = poMapper.selectList(new QueryWrapper<Po>().eq("oid", oid)).get(0);
            operation.setPoId(po2.getId());
            RespBean respBean = null;
            int i1 = operationMapper.updateById(operation);
            if(i1>0){
                respBean = new RespBean(200,"托运单更新成功",null);
            }
            return RespBean.success("订单生成成功！",respBean);
        }
        return RespBean.error("订单生成失败！");
    }

    /**
     * 删除提货单
     * @param po
     * @param id
     * @return
     */
    @Override
    public RespBean deletePo(Po po,Integer id) {
        if(po.getState()<6){
            return RespBean.error("订单尚未完成,禁止删除");
        }
        int i = poMapper.deleteById(po);
        if(i>0){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @Override
    public List<Operation> getNoPoOperation() {
        return operationMapper.getPoOperation();
    }
}
