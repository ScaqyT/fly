package com.xxxx.flyserver.pojo;

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
 * 车辆类型
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_car_type")
@ApiModel(value="CarType对象", description="车辆类型")
public class CarType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "车辆类型")
    private String type;

    @ApiModelProperty(value = "载重(单位：kg)")
    private Integer quality;

    @ApiModelProperty(value = "长(单位：米)")
    private Integer length;

    @ApiModelProperty(value = "宽(单位：米)")
    private Integer width;

    @ApiModelProperty(value = "高(单位：米)")
    private Integer high;


}
