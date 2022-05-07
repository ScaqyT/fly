package com.xxxx.flyserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: fly
 * @description: 车辆搜索关键词
 * @author: cxf
 * @create: 2022-03-09 18:28
 **/
@Data
@Accessors(chain = true)
public class CarSearch{

    private String name;

    private Integer typeId;

    private Integer stateId;

    private Integer locationId;

    private Integer price;


}
