package com.xxxx.flyserver.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 货物类别
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_goods_type")
@ApiModel(value="GoodsType对象", description="货物类别")
public class GoodsType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "类别ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "货物类别")
    private String name;

    @ApiModelProperty("父ID")
    private Integer parentId;

    @ApiModelProperty("子菜单")
    @TableField(exist = false)
    private List<GoodsType> Children;


}
