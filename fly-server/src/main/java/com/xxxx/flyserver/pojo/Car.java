package com.xxxx.flyserver.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 车辆信息
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_car")
@ApiModel(value="Car对象", description="车辆信息")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "车辆编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "车辆名称")
    private String name;

    @ApiModelProperty(value = "车辆类型")
    private Integer cartype;

    @ApiModelProperty(value = "车辆类型2")
    @TableField(exist = false)
    private CarType Type;

    @ApiModelProperty(value = "(单位:万元)")
    private Integer price;

    @ApiModelProperty(value = "车辆状态")
    private Integer state;

    @ApiModelProperty(value = "车辆状态2")
    @TableField(exist = false)
    private CarState carState;

    @ApiModelProperty(value = "区位")
    private Integer location;


}
