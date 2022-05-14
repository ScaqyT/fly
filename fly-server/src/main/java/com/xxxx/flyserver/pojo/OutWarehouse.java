package com.xxxx.flyserver.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 出库信息
 * </p>
 *
 * @author cxf
 * @since 2022-03-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_out_warehouse")
@ApiModel(value="OutWarehouse对象", description="出库信息")
public class OutWarehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "客户ID")
    private Integer customerId;

    @ApiModelProperty(value = "客户")
    @TableField(exist = false)
    private Customer customer;

    @ApiModelProperty(value = "订单名称")
    private String name;
//
//    @ApiModelProperty(value = "货物价格")
//    private Integer price;
//
//    @ApiModelProperty(value = "出库数量")
//    private Integer quantity;

    @ApiModelProperty(value = "出库日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime date;

    @ApiModelProperty(value = "货物ID")
    private Integer goodsId;

    @ApiModelProperty(value = "货物")
    @TableField(exist = false)
    private List<Goods> goods;

    @ApiModelProperty(value = "仓库ID")
    private Integer warehouseId;

    @ApiModelProperty(value = "仓库")
    @TableField(exist = false)
    private Warehouse warehouse;

    @ApiModelProperty(value = "状态")
    private Integer state;

    @ApiModelProperty(value = "订单号")
    private Integer orderId;


}
