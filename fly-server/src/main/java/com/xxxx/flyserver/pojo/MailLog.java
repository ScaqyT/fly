package com.xxxx.flyserver.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author cxf
 * @since 2022-04-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_mail_log")
@ApiModel(value="MailLog对象", description="")
public class MailLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "消息ID")
    private Integer msgId;

    @ApiModelProperty(value = "客户ID")
    private Integer cId;

    @ApiModelProperty(value = "供应商ID")
    private Integer sId;

    @ApiModelProperty(value = "状态（0：消息投递中 1：发送成功 2：发送失败）")
    private Integer state;

    @ApiModelProperty(value = "交换机")
    private String exchange;

    @ApiModelProperty(value = "路由键")
    private String routekey;

    @ApiModelProperty(value = "尝试次数")
    private Integer count;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createtime;

    @ApiModelProperty(value = "尝试时间")
    private LocalDateTime trytime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updatetime;


}
