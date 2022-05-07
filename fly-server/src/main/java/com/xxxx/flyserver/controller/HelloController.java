package com.xxxx.flyserver.controller;

import com.xxxx.flyserver.pojo.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: fly
 * @description:
 * @author: cxf
 * @create: 2022-02-25 17:54
 **/
@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
