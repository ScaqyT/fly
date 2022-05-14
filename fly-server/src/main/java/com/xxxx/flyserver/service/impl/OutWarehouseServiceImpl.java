package com.xxxx.flyserver.service.impl;

import com.xxxx.flyserver.pojo.Goods;
import com.xxxx.flyserver.pojo.OutInSearch;
import com.xxxx.flyserver.pojo.OutWarehouse;
import com.xxxx.flyserver.mapper.OutWarehouseMapper;
import com.xxxx.flyserver.pojo.RespPageBean;
import com.xxxx.flyserver.service.IOutWarehouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.flyserver.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 出库信息 服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Service
public class OutWarehouseServiceImpl extends ServiceImpl<OutWarehouseMapper, OutWarehouse> implements IOutWarehouseService {

    @Autowired
    private OutWarehouseMapper outWarehouseMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<OutWarehouse> getOutWarehouse(OutInSearch outInSearch) {
        List<OutWarehouse> outWarehouse = outWarehouseMapper.getOutWarehouse(outInSearch);
        return outWarehouse;
    }

    @Override
    public Integer getOutGoods() {
        Integer res = (Integer) redisUtil.get("outGoods");;
        if(res==null){
            res = 0;
            List<OutWarehouse> outGoods = outWarehouseMapper.getOutGoods();
            for (OutWarehouse out:outGoods){
                for (Goods goods:out.getGoods()){
                    res += goods.getQuantity();
                }
            }
            redisUtil.set("outGoods",res);
        }
        return res;
    }


}
