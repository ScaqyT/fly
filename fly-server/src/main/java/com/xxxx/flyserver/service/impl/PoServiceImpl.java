package com.xxxx.flyserver.service.impl;

import com.xxxx.flyserver.mapper.InWarehouseMapper;
import com.xxxx.flyserver.pojo.InWarehouse;
import com.xxxx.flyserver.pojo.OrderSearch;
import com.xxxx.flyserver.pojo.Po;
import com.xxxx.flyserver.mapper.PoMapper;
import com.xxxx.flyserver.pojo.RespBean;
import com.xxxx.flyserver.service.IPoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private InWarehouseMapper inWarehouseMapper;

    @Override
    public List<Po> getAllPo(OrderSearch orderSearch) {
        return poMapper.getAllPo(orderSearch);
    }

    @Override
    public RespBean updatePo(Integer id) {
        Po po = poMapper.selectById(id);
        Integer state = po.getState();
        if(state==4){
            po.setState(5);
            RespBean respBean = null;
            InWarehouse inWarehouse = new InWarehouse();
            inWarehouse.setName(po.getName());
            inWarehouse.setPrice(po.getMoney());
            inWarehouse.setDate(po.getCreatedate());
            inWarehouse.setQuantity(po.getQuality());
            inWarehouse.setSupplierId(po.getSupplierId());
            inWarehouse.setOrderId(id);
            inWarehouse.setState(0);
            inWarehouse.setWarehouseId(po.getWarehouseId());

            if(poMapper.updateById(po)>0){
                if(inWarehouseMapper.insert(inWarehouse)>0){
                    respBean = new RespBean(200,"入库单创建成功",null);
                }else{
                    respBean = new RespBean(403,"入库单创建失败",null);
                }
                return RespBean.success("更新成功",respBean);
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
        po.setState(1);
        int i = poMapper.insert(po);
        if(i>0){
            return RespBean.success("订单生成成功！");
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
}
