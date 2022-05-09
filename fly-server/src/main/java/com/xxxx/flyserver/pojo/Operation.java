package com.xxxx.flyserver.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 车辆运营
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_operation")
@ApiModel(value="Operation对象", description="车辆运营")
public class Operation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "车辆编号")
    private Integer carId;

    @ApiModelProperty(value = "车辆")
    @TableField(exist = false)
    private Car car;

    @ApiModelProperty(value = "路线")
    private String way;

    @ApiModelProperty(value = "价格")
    private Integer price;

    @ApiModelProperty(value = "托运人ID")
    private Integer supplierId;

    @ApiModelProperty(value = "托运人")
    @TableField(exist = false)
    private Supplier supplier;

    @ApiModelProperty(value = "收货人ID")
    private Integer customerId;

    @ApiModelProperty(value = "收货人")
    @TableField(exist = false)
    private Customer customer;

    @ApiModelProperty(value = "返回结果，存储过程使用")
    @TableField(exist = false)
    private Integer result;

    @ApiModelProperty(value = "计费方式")
    private Integer chargeMode;

    @ApiModelProperty(value = "计费方式")
    @TableField(exist = false)
    private Chargemode c;

    @ApiModelProperty(value = "取货费")
    private Integer QMoney;

    @ApiModelProperty(value = "送货费")
    private Integer SMoney;

    @ApiModelProperty(value = "运输费")
    private Integer YMoney;

    @ApiModelProperty(value = "状态")
    private Integer state;

    @ApiModelProperty(value = "状态")
    @TableField(exist = false)
    private State s;

    @ApiModelProperty(value = "目的地详细地址")
    private String destination;

    @ApiModelProperty(value = "目的地详细地址Id")
    private Integer destinationId;

    @ApiModelProperty(value = "目的地")
    @TableField(exist = false)
    private Address d;

    @ApiModelProperty(value = "起始地详细地址")
    private String origin;

    @ApiModelProperty(value = "起始地详细地址Id")
    private Integer originId;

    @ApiModelProperty(value = "起始地")
    @TableField(exist = false)
    private Address o;

    @ApiModelProperty(value = "送货单Id")
    private Integer orderId;

    @ApiModelProperty(value = "提货单Id")
    private Integer poId;
}
