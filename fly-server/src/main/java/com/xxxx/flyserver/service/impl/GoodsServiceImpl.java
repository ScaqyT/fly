package com.xxxx.flyserver.service.impl;

import com.xxxx.flyserver.pojo.Goods;
import com.xxxx.flyserver.mapper.GoodsMapper;
import com.xxxx.flyserver.pojo.GoodsSearch;
import com.xxxx.flyserver.pojo.RespBean;
import com.xxxx.flyserver.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.flyserver.util.RedisUtil;
import io.jsonwebtoken.lang.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 货物信息 服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<Goods> getAllGoods(GoodsSearch goodsSearch) {
        List<Goods> goods = (List<Goods>) redisUtil.get("goods");
        if(Collections.isEmpty(goods)){
            goods = goodsMapper.getAllGoods(goodsSearch);
            redisUtil.set("goods",goods);
        }
        return goods;
    }

    @Override
    public RespBean addGoods(Goods goods) {
        int i = goodsMapper.insert(goods);
        if(i>0){
            redisUtil.del("goods");
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @Override
    public RespBean updateGoods(Goods goods) {
        int i = goodsMapper.updateById(goods);
        if(i>0){
            redisUtil.del("goods");
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @Override
    public RespBean deleteGoods(Integer id) {
        int i = goodsMapper.deleteById(id);
        if(i>0){
            redisUtil.del("goods");
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}
