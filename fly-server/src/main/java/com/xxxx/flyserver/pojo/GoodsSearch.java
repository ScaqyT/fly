package com.xxxx.flyserver.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: fly
 * @description: 货物检索
 * @author: cxf
 * @create: 2022-03-13 17:21
 **/
@Data
@Accessors(chain = true)
public class GoodsSearch {

    private Integer goodsId;
    /**
     * 货物类型
     */
    private Integer goodsType;
    /**
     * 货物名称
     */
    private String goodsName;



}
