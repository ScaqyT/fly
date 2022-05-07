package com.xxxx.flyserver.util;

import com.xxxx.flyserver.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @program: fly
 * @description: 用户工具类
 * @author: cxf
 * @create: 2022-02-28 21:51
 **/
@Component
public class AdminUtils {
    //获取用户
    public static Admin getAdmin(){
        return (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
