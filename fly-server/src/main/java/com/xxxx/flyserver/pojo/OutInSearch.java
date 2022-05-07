package com.xxxx.flyserver.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @program: fly
 * @description: 出入库搜索
 * @author: cxf
 * @create: 2022-03-15 11:48
 **/
@Data
@Accessors(chain = true)
public class OutInSearch {

    private Integer id;

    private Integer otherId;

    private String name;

}
