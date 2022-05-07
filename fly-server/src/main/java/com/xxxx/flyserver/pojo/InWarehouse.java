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

/**
 * <p>
 * 入库信息
 * </p>
 *
 * @author cxf
 * @since 2022-03-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_in_warehouse")
@ApiModel(value="InWarehouse对象", description="入库信息")
public class InWarehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "供应商ID")
    private Integer supplierId;

    @ApiModelProperty(value = "供应商")
    @TableField(exist = false)
    private Supplier supplier;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "货物名称")
    private String name;

    @ApiModelProperty(value = "货物价格")
    private Integer price;

    @ApiModelProperty(value = "入库数量")
    private Integer quantity;

    @ApiModelProperty(value = "入库日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime date;

    @ApiModelProperty(value = "货物ID")
    private Integer goodsId;

    @ApiModelProperty(value = "货物")
    @TableField(exist = false)
    private Goods goods;

    @ApiModelProperty(value = "仓库ID")
    private Integer warehouseId;

    @ApiModelProperty(value = "仓库")
    @TableField(exist = false)
    private Warehouse warehouse;

    @ApiModelProperty(value = "订单号")
    private Integer orderId;

    @ApiModelProperty(value = "状态")
    private Integer state;

}
