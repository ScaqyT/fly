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
 * 车辆状态
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_car_state")
@ApiModel(value="CarState对象", description="车辆状态")
public class CarState implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "状态编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "状态名称")
    private String name;


}
