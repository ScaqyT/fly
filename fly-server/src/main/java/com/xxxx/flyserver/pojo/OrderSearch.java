package com.xxxx.flyserver.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @program: fly
 * @description: 订单搜索
 * @author: cxf
 * @create: 2022-03-16 12:28
 **/
@Data
@Accessors(chain = true)
public class OrderSearch {
    /**
     * 订单编号
     */
    private Integer orderId;
    /**
     * 订单状态
     */
    private Integer orderState;
    /**
     * 托运单
     */
    private Integer oid;
}
