package com.xxxx.flyserver.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 司机信息
 * </p>
 *
 * @author cxf
 * @since 2022-03-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_driver")
@ApiModel(value="Driver对象", description="司机信息")
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "司机ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "司机名称")
    private String name;

    @ApiModelProperty(value = "(0:空闲；1:忙碌)")
    private String state;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "体重")
    private String weigth;

    @ApiModelProperty(value = "身高")
    private String high;

    @ApiModelProperty(value = "家庭住址")
    private String address;

    @ApiModelProperty(value = "联系电话")
    private String telphone;

    @ApiModelProperty(value = "紧急联系电话")
    @TableField("sos_phone")
    private String sosPhone;

    @ApiModelProperty(value = "紧急联系人")
    @TableField("sos_name")
    private String sosName;

    @ApiModelProperty(value = "头像")
    @TableField("image")
    private String image;

    @ApiModelProperty(value = "性别")
    @TableField("sex")
    private String sex;


}
