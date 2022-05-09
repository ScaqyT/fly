package com.xxxx.flyserver.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 采购订单信息
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_po")
@ApiModel(value="Po对象", description="采购订单信息")
public class Po implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单号")
    private String number;

    @ApiModelProperty(value = "供应商ID")
    private Integer supplierId;

    @ApiModelProperty(value = "供应商")
    @TableField(exist = false)
    private Supplier supplier;

    @ApiModelProperty(value = "订单状态")
    private Integer state;

    @ApiModelProperty(value = "状态")
    @TableField(exist = false)
    private State stateName;

    @ApiModelProperty(value = "数量")
    private Integer quality;

    @ApiModelProperty(value = "货物名称")
    private String name;

    @ApiModelProperty(value = "创建日期")
    private LocalDateTime createdate;

    @ApiModelProperty(value = "应付金额")
    private Integer money;

//    @ApiModelProperty(value = "仓库ID")
//    private Integer warehouseId;
//
//    @ApiModelProperty(value = "仓库ID")
//    @TableField(exist = false)
//    private Warehouse warehouse;

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
