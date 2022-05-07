package com.xxxx.flyserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: fly
 * @description: 响应类
 * @author: cxf
 * @create: 2022-02-23 14:42
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    private long code;
    private String msg;
    private Object obj;

    /**
     * 成功返回结果
     * @param msg
     * @return
     */
    public static RespBean success(String msg){
        return new RespBean(200,msg,null);
    }

    /**
     * 成功返回结果
     * @param msg
     * @param obj
     * @return
     */
    public static RespBean success(String msg,Object obj){
        return new RespBean(200,msg,obj);
    }

    /**
     * 失败返回结果
     * @param msg
     * @return
     */
    public static RespBean error(String msg){
        return new RespBean(500,msg,null);
    }

    /**
     * 失败返回结果
     * @param msg
     * @param obj
     * @return
     */
    public static RespBean error(String msg,Object obj){
        return new RespBean(500,msg,null);
    }
}
