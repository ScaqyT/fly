package com.xxxx.flyserver.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单信息
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_orders")
@ApiModel(value="Orders对象", description="订单信息")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单号")
    private String number;

//    @ApiModelProperty(value = "货物ID")
//    private Integer goodsId;
//
//    @ApiModelProperty(value = "货物")
//    @TableField(exist = false)
//    private Goods goods;

    @ApiModelProperty(value = "客户ID")
    private String customerId;

    @ApiModelProperty(value = "客户")
    @TableField(exist = false)
    private Customer customer;

    @ApiModelProperty(value = "订单状态")
    private Integer state;

    @ApiModelProperty(value = "状态")
    @TableField(exist = false)
    private State stateName;

    @ApiModelProperty(value = "数量")
    private Integer quality;

    @ApiModelProperty(value = "创建日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime createdate;

    @ApiModelProperty(value = "付款金额")
    private Integer money;

    @ApiModelProperty(value = "地区")
    private Integer addressId;

    @ApiModelProperty(value = "详细地址")
    private String dAddress;

    @ApiModelProperty(value = "计费方式")
    private Integer chargeMode;

    @ApiModelProperty(value = "托运单Id")
    private Integer oid;

    @ApiModelProperty(value = "司机ID")
    private Integer did;
}
