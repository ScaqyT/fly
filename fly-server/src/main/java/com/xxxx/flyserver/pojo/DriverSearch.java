package com.xxxx.flyserver.pojo;

import lombok.Data;
import lombok.experimental.Accessors;


/**
 * @program: fly
 * @description: 司机搜索关键词
 * @author: cxf
 * @create: 2022-03-09 18:28
 **/
@Data
@Accessors(chain = true)
public class DriverSearch{

    private Integer id;

    private String name;

    private String state;



}
