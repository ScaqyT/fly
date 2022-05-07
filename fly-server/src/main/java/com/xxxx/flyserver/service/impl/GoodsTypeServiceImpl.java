package com.xxxx.flyserver.service.impl;

import com.xxxx.flyserver.pojo.GoodsType;
import com.xxxx.flyserver.mapper.GoodsTypeMapper;
import com.xxxx.flyserver.service.IGoodsTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.flyserver.util.RedisUtil;
import io.jsonwebtoken.lang.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 货物类别 服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Service
public class GoodsTypeServiceImpl extends ServiceImpl<GoodsTypeMapper, GoodsType> implements IGoodsTypeService {

    @Autowired
    private GoodsTypeMapper goodsTypeMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<GoodsType> getGoodsType() {
        List<GoodsType> goodsType = ((List<GoodsType>) redisUtil.get("goodsType"));
        if(Collections.isEmpty(goodsType)){
            goodsType = goodsTypeMapper.getGoodsType();
            redisUtil.set("goodsType",goodsType);
        }
        return goodsType;
    }
}
