package com.xxxx.flyserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: fly
 * @description: 分页返回结果
 * @author: cxf
 * @create: 2022-03-04 20:15
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespPageBean {

    /**
     *总条数
     */
    private Long total;
    /**
     *数据list
     */
    private List<?> data;
}
