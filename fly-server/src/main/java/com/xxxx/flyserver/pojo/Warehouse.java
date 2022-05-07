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
 * 仓库信息
 * </p>
 *
 * @author cxf
 * @since 2022-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_warehouse")
@ApiModel(value="Warehouse对象", description="仓库信息")
public class Warehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "仓库ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "仓库名称")
    private String name;

    @ApiModelProperty(value = "区位")
    private Integer locationId;

    @ApiModelProperty(value = "区位")
    @TableField(exist = false)
    private Location location;

    @ApiModelProperty(value = "面积")
    private Integer area;

    @ApiModelProperty(value = "仓库类型")
    private String type;

    @ApiModelProperty(value = "仓库电话")
    private String Wphone;

    @ApiModelProperty(value = "仓库地址")
    private String address;

    @ApiModelProperty(value = "管理员编号")
    private Integer Uid;

    @ApiModelProperty(value = "管理员")
    @TableField(exist = false)
    private Employee employee;

    @ApiModelProperty(value = "管理员")
    @TableField(exist = false)
    private EmployeeType employeeType;


}
