package com.xxxx.flyserver.controller;


import com.xxxx.flyserver.pojo.Goods;
import com.xxxx.flyserver.pojo.GoodsSearch;
import com.xxxx.flyserver.pojo.GoodsType;
import com.xxxx.flyserver.pojo.RespBean;
import com.xxxx.flyserver.service.IGoodsService;
import com.xxxx.flyserver.service.IGoodsTypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 货物信息 前端控制器
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@RestController
@RequestMapping("/warehouse/g/info")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private IGoodsTypeService goodsTypeService;

    @ApiOperation(value = "获取货物信息")
    @GetMapping("/")
    public List<Goods> getAllGoods(GoodsSearch goodsSearch){
        return goodsService.getAllGoods(goodsSearch);
    }

    @ApiOperation(value = "添加货物")
    @PostMapping("/")
    public RespBean addGoods(@RequestBody Goods goods){
        return goodsService.addGoods(goods);
    }

    @ApiOperation(value = "更新货物")
    @PutMapping("/")
    public RespBean updateGoods(@RequestBody Goods goods){
        return goodsService.updateGoods(goods);
    }

    @ApiOperation(value = "删除货物")
    @DeleteMapping("/{id}")
    public RespBean deleteGoods(@PathVariable("id") Integer id){
        return goodsService.deleteGoods(id);
    }

    @ApiOperation(value = "获取货物类型")
    @GetMapping("/goodstype")
    public List<GoodsType> getGoodsType(){
        return goodsTypeService.getGoodsType();
    }

}
