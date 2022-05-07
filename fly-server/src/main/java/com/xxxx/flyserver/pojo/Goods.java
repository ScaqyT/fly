package com.xxxx.flyserver.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 货物信息
 * </p>
 *
 * @author cxf
 * @since 2022-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_goods")
@ApiModel(value="Goods对象", description="货物信息")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "货物ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "货物名称")
    private String name;

    @ApiModelProperty(value = "货物类别")
    private Integer type;

    @ApiModelProperty(value = "货物类别")
    @TableField(exist = false)
    private GoodsType goodsType;

    @ApiModelProperty(value = "货物重量(kg)")
    private Double weight;

    @ApiModelProperty(value = "货物体积")
    private Integer volume;

    @ApiModelProperty(value = "货物数量")
    private Integer quantity;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "起始地详细地址Id")
    private Integer originId;

    @ApiModelProperty(value = "起始地区")
    @TableField(exist = false)
    private Address o;

    @ApiModelProperty(value = "起始地详细地址")
    private String origin;

    @ApiModelProperty(value = "目的地详细地址Id")
    private Integer destinationId;

    @ApiModelProperty(value = "目的地区")
    @TableField(exist = false)
    private Address d;


    @ApiModelProperty(value = "目的地详细地址")
    private String destination;


}
